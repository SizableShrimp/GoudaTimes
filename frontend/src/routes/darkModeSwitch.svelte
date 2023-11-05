<script>
    import { browser } from '$app/environment';
    import { darkModeStore } from '../stores';

    let darkMode = false;
    if (browser) {
        darkMode = document.body.classList.contains('dark') || localStorage.theme === "dark";
    }
	
	function toggle() {
        darkMode = !darkMode;
        window.document.body.classList.toggle('dark');
        localStorage.theme =  darkMode ? "dark" : "light";
        darkModeStore.set(darkMode);
    }
</script>


<button on:click={toggle}>
	{#if darkMode }
		☀️
	{:else}
		🌙
	{/if}
</button>

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