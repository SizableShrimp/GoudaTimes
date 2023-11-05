<script>
    import { browser } from '$app/environment';
    import '../app.css'
    import { darkModeStore, articleModeStore } from '../stores';
    import Footer from './footer.svelte';
    import Header from './header.svelte';
    let isDark = false;
    let isArticleMode = false;
    if (browser) {
        isDark = document.body.classList.contains('dark');
        isArticleMode = document.URL.includes("/articles/");
        darkModeStore.set(isDark);
        articleModeStore.set(isArticleMode);
    }
</script>

<div id="container" style="--accent-color: #e3ba42">
    <Header />
    <slot isDark={isDark} />
    <Footer />
</div>

<style>
    #container {
        min-height: calc(100vh);
        display: flex;
        position: relative;
        flex-direction: column;
    }
</style>