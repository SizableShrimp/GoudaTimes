<script>
    /** @type {import('./$types').PageData} */
	export let data;
    console.log(data);
</script>

<h1>{data.article.title}</h1>
{#each data.article.content.split("\n") as paragraph}
    <p>{paragraph}</p>
{/each}