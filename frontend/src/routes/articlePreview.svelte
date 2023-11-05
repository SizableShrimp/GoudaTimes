<script lang="ts">
    import { Sizes, type Article } from "$lib/article";
    export let article: Article;
    export let previewLen = 100;
    export let size: Sizes = Sizes.medium;
    let text = article.content;
    if (text.length > previewLen) {
        text = text.slice(0, previewLen - 3) + "...";
    }
    let title = article.title;
    if (title.length > 90) {
        title = text.slice(0, 87) + "...";
    }
    
</script>

<a class={Sizes[size]} href={"/articles/" + article.id}>
    {#if size === Sizes.image || size === Sizes.small || size === Sizes.extraLong}
        <img class="bigImage" src={article.headerImageUrl} alt={article.headerImageAttribution}/>
    {/if}
    <h2>{title}</h2>
    <p>{text}</p>
</a>


<style lang="scss">
    .extraLong {
        display: grid;
        grid-template-columns: 1fr 3fr 2fr;
        gap: 1rem;
        img {
            align-self: center;
        }
    } 
    .small {
        align-self: baseline;
        display: flex;
        flex-direction: column;
        gap: 1rem;
        img {
            max-height: 13rem;
            width: 100%;
            object-fit: cover;
        }
    }
    a {
        text-decoration: none;
        color: var(--color);
    }
    h2 {
        font-size: 1.5rem;
        margin-bottom: 0.5rem;
    }
</style>
