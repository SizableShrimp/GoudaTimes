<script lang="ts">
    enum sizes {
        small,
        long,
        big
    }
    export let title: string = "Cheesed again";
    export let text: string = "Lorem ipsum dolor sit amet";
    export let link: string = "#";
    export let image: string = "https://picsum.photos/200";
    export let size: sizes = sizes.big;
    if (text.length > 100) {
        text = text.slice(0, 100) + "...";
    }
</script>

<a href={link}>
    <h2>{title}</h2>
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