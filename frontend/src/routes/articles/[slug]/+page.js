const baseURL = "https://gouda.tsuni.dev"
/** @type {import('./$types').PageLoad} */
export async function load({fetch, params}) {
    const data = await fetch(baseURL + "/api/articles/" + params.slug).then(r => r.json());
    return {
        article: data
    };
}
