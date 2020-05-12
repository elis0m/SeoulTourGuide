package com.example.som;

import android.os.AsyncTask;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.URL;
import java.util.ArrayList;

public class WifiPublicData {

    private static WifiPublicData wifiPublicData;


    public static ArrayList<WifiData> WifiDataArrayList;

    public ParsePublicWifi parsePublicWifi;

    String tag_name = null;
    WifiData WifiData;
    boolean bSet = false;

    static double[] xml_Y = new double[250];
    static double[] xml_X = new double[250];


    public static WifiPublicData getInstance() {
        if (wifiPublicData == null) {
            wifiPublicData = new WifiPublicData();
        }
        return wifiPublicData;
    }

    public WifiPublicData() {
        WifiData = new WifiData();
        WifiDataArrayList = new ArrayList<WifiData>(120);
        parsePublicWifi = new ParsePublicWifi();
        parsePublicWifi.execute();

    }

    public static ArrayList<WifiData> getWifiDataArrayList() {
        return WifiDataArrayList;
    }

    public void setWifiDataArrayList(ArrayList<WifiData> WifiDataArrayList) {
        this.WifiDataArrayList = WifiDataArrayList;
    }

    public class ParsePublicWifi extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... params) {

            for (int i = 1; i < 5000; i += 1000) {
                try {
                    WifiActivity.guArr = "중구";
                    String url = "http://openapi.seoul.go.kr:8088/444e5a6279736f6d3130307a4d506f62/xml/PublicWiFiPlaceInfo/1/1000/"+WifiActivity.guArr;
                    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                    XmlPullParser parser = factory.newPullParser();
                    URL xmlUrl = new URL(url);
                    xmlUrl.openConnection().getInputStream();
                    parser.setInput(xmlUrl.openStream(), "utf-8");
                    int eventType = parser.getEventType();

                    while (eventType != XmlPullParser.END_DOCUMENT) {

                        if (eventType == XmlPullParser.START_TAG) {
                            tag_name = parser.getName();
                            if (tag_name.equals("INSTL_X") | tag_name.equals("INSTL_Y"))
                                bSet = true;
                        } else if (eventType == XmlPullParser.TEXT) {
                            if (bSet) {
                                String data = parser.getText();
                                switch (tag_name) {
                                    case "INSTL_X":
                                        WifiData.setLongitude(data);
                                        break;
                                    case "INSTL_Y":
                                        WifiData.setLatitude(data);
                                        WifiDataArrayList.add(new WifiData(WifiData.getLatitude(), WifiData.getLongitude()));
                                        Log.v("test0", "wifi0 좌표 : " + WifiDataArrayList.get(WifiDataArrayList.size() - 1).getLatitude() + "/" +WifiDataArrayList.get(WifiDataArrayList.size() - 1).getLongitude());

                                        xml_Y[WifiDataArrayList.size() - 1] = Double.parseDouble(WifiDataArrayList.get(WifiDataArrayList.size() - 1).getLatitude());
                                        WifiActivity.double_Y[WifiDataArrayList.size() - 1] = xml_Y[WifiDataArrayList.size() - 1];
                                        xml_X[WifiDataArrayList.size() - 1] = Double.parseDouble(WifiDataArrayList.get(WifiDataArrayList.size() - 1).getLongitude());
                                        WifiActivity.double_X[WifiDataArrayList.size() - 1] = xml_X[WifiDataArrayList.size() - 1];
                                        break;
                                }
                                bSet = false;
                            }
                        } else if (eventType == XmlPullParser.END_TAG) {
                        }
                        eventType = parser.next();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return "";
        }
        @Override
        public void onPostExecute(String result) {
            super.onPostExecute(result);
        }
    }
}