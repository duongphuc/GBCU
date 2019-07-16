package com.example.gbcu.data.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name="rss", strict = false)
public class NewsResponse {
    @Element(name="channel")
    public Channel channel;

    @Root(name = "item", strict = false)
    public static class Item {

        @Element(name = "title", data = true)
        private String title;
        @Element(name = "description")
        private String description;
        @Element(name = "pubDate")
        private String pubDate;
        @Element(name = "link")
        private String link;

        public String getLink() {
            return link;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getPubDate() {
            return pubDate;
        }

        public String getImgUrl() {
            return "https://news.bbcimg.co.uk/nol/shared/img/bbc_news_120x60.gif";
        }
    }

    @Root(name = "channel", strict = false)
    public static class Channel  {
        @ElementList(inline = true, name="item")
        public ArrayList<Item> items;

        public ArrayList<Item> getItems() {
            return items;
        }
    }
}
