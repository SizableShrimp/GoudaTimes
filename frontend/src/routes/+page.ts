const baseURL = "http://localhost:8081"
/** @type {import('./$types').PageLoad} */
export async function load({fetch}) {
    const data = await fetch(baseURL + "/api/articles").then(r => r.json()) as import('$lib/article').Article[];
    // list of articles in random order, sort by dateWritten
    data.sort((a, b) => {
        const dateA = new Date(a.dateWritten);
        const dateB = new Date(b.dateWritten);
        return dateB.getTime() - dateA.getTime();
    });
    for (let i = 0; i < data.length; i++) {
        const title = data[i].title;
        data[i].content.replace(title, "");
    }
    return {
        articles: data
    };
}