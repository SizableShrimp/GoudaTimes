<script>
    import GoudaTimesImg from "../goudatimes.png";
    import DarkModeSwitch from "./darkModeSwitch.svelte";
    const today = new Date();
    const formatted = new Intl.DateTimeFormat("en-US", {
        dateStyle: "full",
    }).format(today);
</script>

<div class="centered-block">
    <div class="left">
        <strong>{formatted}</strong>
        <p>Volume 1, Issue 1</p>
    </div>
    <div class="right">
        <DarkModeSwitch/>
    </div>
    <a href="/">
        <img src={GoudaTimesImg} alt="" />
    </a>
    <div class="divider" />
    <div class="divider" />
</div>

<style>
    .centered-block {
        width: 100%;
        height: 10rem;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        position: relative;
        padding: 1rem;
    }
    .left {
        position: absolute;
        left: 1rem;
    }
    .right {
        position: absolute;
        right: 1rem;
    }
    .divider {
        margin-top: 3px;
        width: 100%;
        height: 1px;
        background-color: var(--accent-color);
    }
    img {
        height: 5rem;
        margin-bottom: 0.75rem;
    }

    @media (max-width: 1100px) {
        .sideline {
            display: none;
        }
        .centered-block {
            height: 5rem;
            display: block;
        }
        img {
            height: 3rem;
            margin: auto;
        }
    }
</style>
