<script>
    import BigArticleGroup from './bigArticleGroup.svelte';
    import MediumArticleGroup from './mediumArticleGroup.svelte';
    import SmallArticleGroup from './smallArticleGroup.svelte';

    /** @type {import('./$types').PageData} */
	export let data;
    let groupedArticles = [];
    let nextSplit = 5;
    for (let i = 0; i < data.articles.length; i += nextSplit) {
        groupedArticles.push(data.articles.slice(i, i + nextSplit));
        if (data.articles.length - i >= 5) {
            nextSplit = (nextSplit == 5) ? 3 : 5;
        } else if (data.articles.length - i >= 3) {
            nextSplit = 3;
        } else {
            nextSplit = 1;
        }
        console.log(nextSplit);
    }
    for (let i = 0; i < groupedArticles.length; i++) {
        console.log(groupedArticles[i].length);
    }
</script>

{#each groupedArticles as group}
    {#if group.length == 5}
        <BigArticleGroup articles={group} flipped={Math.random() > 0.5}/>
    {:else if group.length == 3}
        <MediumArticleGroup articles={group} />
    {:else if group.length == 1}
        <SmallArticleGroup articles={group} />
    {:else}
        <p>Something went wrong</p>
    {/if}
    <div class="article-divider" />
{/each}

<style>
    .article-divider {
        width: 100%;
        height: 1px;
        background-color: #e3ba42;
        margin: 1rem 0;
    }
</style>