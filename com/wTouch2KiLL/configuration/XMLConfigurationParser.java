package com.wTouch2KiLL.configuration;

import android.content.Context;
import com.wTouch2KiLL.Factory;
import com.wTouch2KiLL.controllers.WidgetsController;
import java.io.InputStream;
import javax.xml.parsers.SAXParserFactory;

public class XMLConfigurationParser {
    private static final String EXCEPTION_MESSAGE = "Wrong format of configuration.xml file";
    private static final int RESOURCE_ID = 2131099648;
    private Context context;

    public XMLConfigurationParser(Context context) {
        this.context = context;
    }

    public WebWidgetConfiguration parse() throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            WidgetsController widgetsController = Factory.getInstance().getWidgetsController();
            WebWidgetConfiguration widgetConfiguration = new WebWidgetConfiguration();
            widgetsController.removeAll();
            factory.newSAXParser().parse(getConfigurationStream(), new XMLConfigurationHandler(widgetConfiguration, widgetsController));
            return widgetConfiguration;
        } catch (Exception e) {
            throw new Exception(EXCEPTION_MESSAGE);
        }
    }

    private InputStream getConfigurationStream() throws Exception {
        try {
            return this.context.getResources().openRawResource(RESOURCE_ID);
        } catch (Exception e) {
            throw new Exception("Couldn't find configuration file");
        }
    }
}
