package com.wTouch2KiLL.suggestions;

public class RemoteSuggestionItem implements SuggestionItem {
    private String text;

    public RemoteSuggestionItem(String text) {
        this.text = text;
    }

    public String getAutocompleteText() {
        return this.text;
    }
}
