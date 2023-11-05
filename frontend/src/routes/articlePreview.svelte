<script lang="ts">
    import { Sizes, type Article } from "$lib/article";
    export let article: Article;
    export let previewLen = 100;
    export let size: Sizes = Sizes.small;
    let text = article.content;
    if (text.length > previewLen) {
        text = text.slice(0, 97) + "...";
    }
</script>

<a href={"/articles/" + article.id}>
    {#if size === Sizes.image}
        <img src={article.headerImageUrl} alt={article.headerImageAttribution}/>
    {/if}
    <h2>{article.title}</h2>
    <p>{text}</p>
</a>

<style>
    a {
        text-decoration: none;
        color: black;
    }
    h2 {
        font-size: 1.5rem;
        margin-bottom: 0.5rem;
    }
</style>
