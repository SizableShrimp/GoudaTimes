function getInitialColorMode() {
    const persistedColorPreference = window.localStorage.getItem("theme");
    const hasPersistedPreference = typeof persistedColorPreference === "string";

    if (hasPersistedPreference) {
        return persistedColorPreference;
    }
    return "light";
}

(function initTheme() {
    var theme = getInitialColorMode();
    if (theme === "dark") {
        window.document.body.classList.add("dark");
    }
})();