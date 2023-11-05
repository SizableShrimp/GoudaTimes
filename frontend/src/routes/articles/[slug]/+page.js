const baseURL = "http://localhost:8081"
/** @type {import('./$types').PageLoad} */
export async function load({fetch, params}) {
    const data = await fetch(baseURL + "/api/articles/" + params.slug).then(r => r.json());
    return {
        article: data
    };
}