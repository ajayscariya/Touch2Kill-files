package mf.org.apache.xml.resolver.apps;

import java.net.MalformedURLException;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xml.resolver.helpers.FileURL;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public class XParseError implements ErrorHandler {
    private String baseURI;
    private int errorCount;
    private int fatalCount;
    private int maxMessages;
    private boolean showErrors;
    private boolean showWarnings;
    private int warningCount;

    public XParseError(boolean errors, boolean warnings) {
        this.showErrors = true;
        this.showWarnings = false;
        this.maxMessages = 10;
        this.fatalCount = 0;
        this.errorCount = 0;
        this.warningCount = 0;
        this.baseURI = XMLConstants.NULL_NS_URI;
        this.showErrors = errors;
        this.showWarnings = warnings;
        try {
            this.baseURI = FileURL.makeURL("basename").toString();
        } catch (MalformedURLException e) {
        }
    }

    public int getErrorCount() {
        return this.errorCount;
    }

    public int getFatalCount() {
        return this.fatalCount;
    }

    public int getWarningCount() {
        return this.warningCount;
    }

    public int getMaxMessages() {
        return this.maxMessages;
    }

    public void setMaxMessages(int max) {
        this.maxMessages = max;
    }

    public void error(SAXParseException exception) {
        this.errorCount++;
        if (this.showErrors && this.errorCount + this.warningCount < this.maxMessages) {
            message("Error", exception);
        }
    }

    public void fatalError(SAXParseException exception) {
        this.errorCount++;
        this.fatalCount++;
        if (this.showErrors && this.errorCount + this.warningCount < this.maxMessages) {
            message("Fatal error", exception);
        }
    }

    public void warning(SAXParseException exception) {
        this.warningCount++;
        if (this.showWarnings && this.errorCount + this.warningCount < this.maxMessages) {
            message("Warning", exception);
        }
    }

    private void message(String type, SAXParseException exception) {
        String filename = exception.getSystemId();
        if (filename.startsWith(this.baseURI)) {
            filename = filename.substring(this.baseURI.length());
        }
        System.out.print(new StringBuilder(String.valueOf(type)).append(":").append(filename).append(":").append(exception.getLineNumber()).toString());
        if (exception.getColumnNumber() > 0) {
            System.out.print(":" + exception.getColumnNumber());
        }
        System.out.println(":" + exception.getMessage());
    }
}
