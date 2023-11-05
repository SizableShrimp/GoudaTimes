<script lang="ts">
    import ArticlePreview from "./articlePreview.svelte";
    import { Sizes, type Article } from "$lib/article";
    export let articles: Article[];
    export let flipped: boolean = false;
    if (articles.length < 5) {
        throw new Error("Not enough articles");
    }
</script>

<div class="horizontal">
    {#if flipped}
        <div class="big-content">
            {#if articles[0].headerImageUrl}
                <ArticlePreview article={articles[0]} size={Sizes.image} />
            {:else}
                <ArticlePreview article={articles[0]} previewLen={400} />
            {/if}
            <div class="article-divider" />
            <ArticlePreview article={articles[1]} size={Sizes.long}/>
        </div>
        <div class="vertical-divider" />
        <div class="small-content">
            <ArticlePreview article={articles[2]} />
            <div class="article-divider" />
            <ArticlePreview article={articles[3]} />
            <div class="article-divider" />
            <ArticlePreview article={articles[4]} />
        </div>
    {:else}
        <div class="small-content">
            <ArticlePreview article={articles[2]} />
            <div class="article-divider" />
            <ArticlePreview article={articles[3]} />
            <div class="article-divider" />
            <ArticlePreview article={articles[4]} />
        </div>
        <div class="vertical-divider" />
        <div class="big-content">
            {#if articles[0].headerImageUrl}
                <ArticlePreview article={articles[0]} size={Sizes.image} />
            {:else}
                <ArticlePreview article={articles[0]} previewLen={400} />
            {/if}
            <div class="article-divider" />
            <ArticlePreview article={articles[1]} size={Sizes.long}/>
        </div>
    {/if}
</div>

<style>
    .content-item {
        min-width: 10rem;
        height: 10rem;
        background-color: lightblue;
    }
    .horizontal {
        display: grid;
        grid-template-columns: 1fr 0.1fr 1fr;
        align-items: center;
        flex-direction: row;
    }
    .big-content {
        flex-grow: 3;
        align-self: self-end;
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
    @media (max-width: 700px) {
        .horizontal {
            flex-direction: column;
        }
        .vertical-divider {
            width: 100%;
            height: 1px;
            background-color: var(--accent-color);
            margin: 0.5rem 0;
        }
        .big-content {
            flex-grow: 1;
        }
        .small-content {
            flex-grow: 1;
        }
    }
</style>
