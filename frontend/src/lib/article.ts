export interface Article {
    id: number;
    title: string;
    dateWritten: string;
    byLine: string;
    headerImageUrl: string;
    headerImageAttribution: string;
    sourceDomain: string;
    sortedCategoriesJson: string;
    originalUrl: string;
    content: string;
}

export enum Sizes {
    small,
    medium,
    image,
    long,
    extraLong,
}