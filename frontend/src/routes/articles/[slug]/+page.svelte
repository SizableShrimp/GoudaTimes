<script>
    import { onMount } from 'svelte';
    import { articleModeStore, darkModeStore } from '../../../stores';
    import Paywall from './paywall.svelte';
    /** @type {import('./$types').PageData} */
	export let data;
    const formatted = new Intl.DateTimeFormat("en-US", { dateStyle: "full" }).format(new Date(data.article.dateWritten));
    let isDark = false;
    onMount(() => {
        darkModeStore.subscribe((value) => {
            isDark = value;
        });
        articleModeStore.set(true);
    });
</script>

<div class="article">
    <h1>{data.article.title}</h1>
    <i>{formatted}</i>
    <p>{data.article.byLine} <a href="/about"><small>Not really</small></a></p>
    {#if data.article.headerImageUrl}
        <img src={data.article.headerImageUrl} alt={data.article.headerImageAttribution}/>
        <small>{data.article.headerImageAttribution}</small>
    {/if}
    {#each data.article.content.split("\n") as paragraph}
        <p>{paragraph}</p>
    {/each}
</div>
<Paywall />
{#if !isDark}
<a class="attr" href={data.article.originalUrl}>Via the New York Times</a>
{/if}

<style>
    .article {
        max-width: 50rem;
        margin: auto;
    }
    p {
        margin-bottom: 1rem;
    }
    .attr {
        display: block;
        text-align: center;
        margin-top: 1rem;
        color: var(--color);
    }
</style>