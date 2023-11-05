<script lang="ts">
    import ArticlePreview from "./articlePreview.svelte";
    import {Sizes, type Article} from "$lib/article";
    export let articles: Article[];
    if (articles.length < 3) {
        throw new Error("Not enough articles");
    }
</script>

<div class="horizontal">
    <ArticlePreview article={articles[0]} size={Sizes.small} />
    <div class="vertical-divider" />
    <ArticlePreview article={articles[1]} size={Sizes.small} />
    <div class="vertical-divider" />
    <ArticlePreview article={articles[2]} size={Sizes.small} />
</div>

<style>
    .content-item {
        min-width: 10rem;
        height: 10rem;
        background-color: lightblue;
    }
    .horizontal {
        display: grid;
        grid-template-columns: 1fr 0.1fr 1fr 0.1fr 1fr;
        align-items: center;
    }
    .big-content {
        flex-grow: 3;
    }
    .vertical-divider {
        /* height: 100%; */
        width: 1px;
        background-color: var(--accent-color);
        margin: 0 1rem;
        align-self: stretch;
    }
    .article-divider {
        width: 100%;
        height: 1px;
        background-color: var(--accent-color);
        margin: 0.5rem 0;
    }
    .small-content {
        flex-grow: 1;
    }
</style>
