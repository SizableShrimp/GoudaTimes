<script>
    import { onMount } from "svelte";
    import { darkModeStore } from "../stores";
    import BigArticleGroup from "./bigArticleGroup.svelte";
    import MediumArticleGroup from "./mediumArticleGroup.svelte";
    import SmallArticleGroup from "./smallArticleGroup.svelte";

    /** @type {import('./$types').PageData} */
    export let data;
    export let isDark = false;
    onMount(() => {
        darkModeStore.subscribe((value) => {
            isDark = value;
        });
    });
    let groups;
    $: {
        const groupArticles = (articles) => {
            let groupedArticles = [];
            let nextSplit = 3;
            for (let i = 0; i < articles.length; i += nextSplit) {
                if (articles.length - i > 5) {
                    nextSplit = nextSplit == 5 ? 3 : 5;
                } else if (articles.length - i > 3) {
                    nextSplit = 3;
                } else {
                    nextSplit = 1;
                }
                groupedArticles.push(articles.slice(i, i + nextSplit));
            }
            return groupedArticles;
        }
        if (isDark) groups = groupArticles(data.darkArticles)
        else groups = groupArticles(data.articles)
    }
</script>

{#key groups}
<main>
    {#each groups as group}
        {#if group.length == 5 || group.length == 4}
            <BigArticleGroup articles={group} flipped={Math.random() > 0.5} />
        {:else if group.length == 3}
            <MediumArticleGroup articles={group} />
        {:else if group.length == 1}
            <SmallArticleGroup articles={group} />
        {:else}
            <p>Something went wrong: {group.length}</p>
        {/if}
        <div class="article-divider" />
    {/each}
</main>
{/key}

<style>
    main {
        max-width: 900px;
        margin: auto;
        padding: 0 1rem;
    }
    .article-divider {
        width: 100%;
        height: 1px;
        background-color: var(--accent-color);
        margin: 1rem 0;
    }
</style>
