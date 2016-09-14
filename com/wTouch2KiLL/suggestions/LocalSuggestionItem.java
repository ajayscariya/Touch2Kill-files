package com.wTouch2KiLL.suggestions;

import mf.javax.xml.XMLConstants;

public class LocalSuggestionItem implements SuggestionItem {
    String title;
    String url;

    public LocalSuggestionItem(String title, String url) {
        if (title == null) {
            title = XMLConstants.NULL_NS_URI;
        }
        this.title = title;
        if (url == null) {
            url = XMLConstants.NULL_NS_URI;
        }
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAutocompleteText() {
        return this.url;
    }
}
