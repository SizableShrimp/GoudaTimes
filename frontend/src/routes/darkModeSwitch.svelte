<script>
    import { browser } from '$app/environment';
    import { articleModeStore, darkModeStore } from '../stores';

    let isArticleMode = false;
    let darkMode = false;
    if (browser) {
        darkMode = document.body.classList.contains('dark') || localStorage.theme === "dark";
        isArticleMode = document.URL.includes("/articles/");
    }
	
	function toggle() {
        darkMode = !darkMode;
        window.document.body.classList.toggle('dark');
        localStorage.theme =  darkMode ? "dark" : "light";
        darkModeStore.set(darkMode);
    }

    articleModeStore.subscribe(x => {
        isArticleMode = x;
    });
</script>


{#if !isArticleMode}
    <button on:click={toggle}>
        {#if darkMode }
            ☀️
        {:else}
            🌙
        {/if}
    </button>
{/if}

<style>
	:root{
		--bg-color: #FFFFFF;
		--text-color: #000000;
	}
	
	:global(body) {
		background: var(--bg-color);
		color: var(--text-color);
	}
	
	:global(body.dark) {
		--bg-color: #000000;
		--text-color: #FFFFFF;
	}
    button {
        width: 2.5rem;
        height: 2.5rem;
        padding: 0;
        line-height: 0;
        background: transparent;
        border: 2px solid var(--accent-color);
        border-radius: 1rem;
    }
</style>