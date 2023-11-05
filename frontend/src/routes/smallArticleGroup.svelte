<script lang="ts">
    import ArticlePreview from "./articlePreview.svelte";
    import { Sizes, type Article } from "$lib/article";
    export let articles: Article[];
    if (articles.length < 1) {
        throw new Error("Not enough articles");
    }
</script>

<div class="horizontal">
    <ArticlePreview article={articles[0]} size={Sizes.extraLong} />
</div>

<style>
    .content-item {
        min-width: 10rem;
        height: 10rem;
        background-color: lightblue;
    }
    .horizontal {
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
