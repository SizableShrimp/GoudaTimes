const baseURL = "http://thecheesytimes.sizableshrimp.me"
/** @type {import('./$types').PageLoad} */
export async function load({fetch}) {
    const data = await fetch(baseURL + "/api/articles?filterDomain=nytimes.com").then(r => r.json()) as import('$lib/article').Article[];
    // list of articles in random order, sort by dateWritten
    data.sort((a, b) => {
        const dateA = new Date(a.dateWritten);
        const dateB = new Date(b.dateWritten);
        return dateB.getTime() - dateA.getTime();
    });
    const dark = await fetch(baseURL + "/api/articles?filterDomain=darkmode._").then(r => r.json()) as import('$lib/article').Article[];
    // list of articles in random order, sort by dateWritten
    dark.sort((a, b) => {
        const dateA = new Date(a.dateWritten);
        const dateB = new Date(b.dateWritten);
        return dateB.getTime() - dateA.getTime();
    });
    return {
        articles: data,
        darkArticles: dark
    };
}