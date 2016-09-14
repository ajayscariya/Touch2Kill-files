package com.wTouch2KiLL.suggestions;

import java.util.ArrayList;

public interface SuggestionsListener {
    void onReceiveSuggestions(ArrayList<RemoteSuggestionItem> arrayList, String str);
}
