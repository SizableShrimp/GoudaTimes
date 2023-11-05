<script>
    import { onMount } from 'svelte';
    import { darkModeStore } from '../../../stores';
    /** @type {import('./$types').PageData} */
	export let data;
    const formatted = new Intl.DateTimeFormat("en-US", { dateStyle: "full" }).format(new Date(data.article.dateWritten));
    let isDark = false;
    onMount(() => {
        darkModeStore.subscribe((value) => {
            isDark = value;
        });
    });
</script>

<div class="article">
    <h1>{data.article.title}</h1>
    <i>{formatted}</i>
    {#if data.article.headerImageUrl}
        <img src={data.article.headerImageUrl} alt={data.article.headerImageAttribution}/>
        <small>{data.article.headerImageAttribution}</small>
    {/if}
    {#each data.article.content.split("\n") as paragraph}
        <p>{paragraph}</p>
    {/each}
    {#if !isDark}
        <a href={data.article.originalUrl}>Via the New York Times</a>
    {/if}
</div>

<style>
    .article {
        max-width: 50rem;
        margin: auto;
    }
</style>