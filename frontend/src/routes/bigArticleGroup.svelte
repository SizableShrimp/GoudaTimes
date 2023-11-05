<script lang="ts">
    import ArticlePreview from "./articlePreview.svelte";
    import { Sizes, type Article } from "$lib/article";
    export let articles: Article[];
    export let flipped = false;
    if (articles.length < 5) {
        throw new Error("Not enough articles");
    }
</script>

<div class="horizontal">
    <div class={flipped ? "small-content" : "big-content"}>
        <ArticlePreview article={articles[0]} size={Sizes.image} />
    </div>
    <div class="vertical-divider" />
    <div class={flipped ? "big-content" : "small-content"}>
        <ArticlePreview article={articles[1]} />
        <div class="article-divider" />
        <ArticlePreview article={articles[2]} />
        <div class="article-divider" />
        <ArticlePreview article={articles[3]} />
        <div class="article-divider" />
        <ArticlePreview article={articles[4]} />
    </div>
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
