<script>
    import '../app.css'
    import Footer from './footer.svelte';
    import Header from './header.svelte';
</script>

<div id="container" style="--accent-color: #e3ba42">
    <Header />
    <main>
        <slot />
    </main>
    <Footer />
</div>

<style>
    #container {
        min-height: calc(100vh);
        display: flex;
        flex-direction: column;
    }
    main {
        padding: 0 1rem;
    }
</style>