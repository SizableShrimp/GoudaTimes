<script>
    import GoudaTimesImg from "../goudatimes.png";
</script>

<div class="block">
    <div class="divider" />
    <div class="divider" />
    <img src={GoudaTimesImg} alt="" />
    <a href="/about">About</a>
    <a href="https://github.com/SizableShrimp/TheCheesyTimes">GitHub</a>
</div>

<style>
    img {
        height: 2rem;
        margin-top: 0.75rem;
        filter: contrast(0) brightness(100);
    }
    .block {
        width: 100%;
        min-height: 10rem;
        height: 100%;
        background-color: var(--accent-color);
        margin-top: auto;
        padding: 1rem;
    }
    .divider {
        margin-top: 3px;
        width: 100%;
        height: 1px;
        background-color: white;
    }
    a {
        color: white;
        margin-top: 0.5rem;
        display: block;
    }
</style>