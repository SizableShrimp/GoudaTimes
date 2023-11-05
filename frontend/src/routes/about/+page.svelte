<!-- - [ ]  Add a page explaining what this is and how the content is generated
- [ ]  Link to this page from the header or footer (idk which best)
- [ ]  Have some link to it at the end of the by-line, like “By Newyork Timesauthor (except…)” where the parenthensized text links to the explanation page -->

<main>
    <h1>What is this?</h1>
    <p>This project is an AI-generated news site. None of the content is intended to be factual nor is it written by humans. Named writers are unaffiliated with the site.</p>
    <h2>What's our process?</h2>
    <ul>
        <li>We start with article headlines from The New York Times</li>
        <li>We then use <a href="https://openai.com/blog/openai-api/">OpenAI's GPT-3.5 API</a> to generate a new, cheesy title</li>
        <li>Finally, we use GPT-3.5 again to generate a new article based on the new title and serve it on the frontend</li>
    </ul>
</main>

<style>
    main {
        max-width: 50rem;
        margin: 0 auto;
    }
    p {
        margin-bottom: 1rem;
    }
</style>