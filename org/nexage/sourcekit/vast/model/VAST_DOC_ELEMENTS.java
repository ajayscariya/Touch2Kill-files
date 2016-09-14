package org.nexage.sourcekit.vast.model;

import mf.javax.xml.transform.OutputKeys;

public enum VAST_DOC_ELEMENTS {
    vastVersion("2.0"),
    vasts("VASTS"),
    vastAdTagURI("VASTAdTagURI"),
    vastVersionAttribute(OutputKeys.VERSION);
    
    private String value;

    private VAST_DOC_ELEMENTS(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
