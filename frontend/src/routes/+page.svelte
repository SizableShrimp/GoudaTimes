<script>

    import Article from "./articlePreview.svelte";

</script>
<main>
    <div class="big-content">
        <Article />
        <div class="article-divider" />
        <Article />
    </div>
    <div class="vertical-divider" />
    <div class="small-content">
        <Article />
        <div class="article-divider" />
        <Article />
        <div class="article-divider" />
        <Article />
    </div>
</main>

<style>
    .content-item {
        min-width: 10rem;
        height: 10rem;
        background-color: lightblue;
    }
    main {
        display: flex;
        align-items: center;
        flex-direction: row;
    }
    .big-content {
        flex-grow: 3;
    }
    .vertical-divider {
        /* height: 100%; */
        width: 1px;
        background-color: #e3ba42;
        margin: 0 1rem;
        align-self: stretch;
    }
    .article-divider {
        width: 100%;
        height: 1px;
        background-color: #e3ba42;
        margin: 0.5rem 0;
    }
    .small-content {
        flex-grow: 1;
    }
</style>
