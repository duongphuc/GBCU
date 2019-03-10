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
        @Element(name = "thumbnail", required = false)
        private Media imgUrl;

        public String getLink() {
            return link;
        }

        @Root(name = "thumbnail", strict = false)
        public static class Media {
            @Attribute(name = "url")
            private String url;

            public String getUrl() {
                return url;
            }
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

        public Media getImgUrl() {
            return imgUrl;
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
