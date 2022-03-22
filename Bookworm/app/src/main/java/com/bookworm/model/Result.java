package com.bookworm.model;

import java.util.ArrayList;
import java.util.List;

class ReadingModes{
    public boolean text;
    public boolean image;
}

class PanelizationSummary{
    public boolean containsEpubBubbles;
    public boolean containsImageBubbles;
}

class IndustryIdentifier{
    public String type;
    public String identifier;
}

class ListPrice{
    public double amount;
    public String currencyCode;
    public int amountInMicros;
}

class RetailPrice{
    public double amount;
    public String currencyCode;
    public int amountInMicros;
}

class Offer{
    public int finskyOfferType;
    public ListPrice listPrice;
    public RetailPrice retailPrice;
    public boolean giftable;
}

class SaleInfo{
    public String country;
    public String saleability;
    public boolean isEbook;
    public ListPrice listPrice;
    public RetailPrice retailPrice;
    public String buyLink;
    public ArrayList<Offer> offers;
}

 class Epub{
    public boolean isAvailable;
    public String acsTokenLink;
}

 class Pdf{
    public boolean isAvailable;
    public String acsTokenLink;
}

 class AccessInfo{
    public String country;
    public String viewability;
    public boolean embeddable;
    public boolean publicDomain;
    public String textToSpeechPermission;
    public Epub epub;
    public Pdf pdf;
    public String webReaderLink;
    public String accessViewStatus;
    public boolean quoteSharingAllowed;
}

class Item{
    public String kind;
    public String id;
    public String etag;
    public String selfLink;
    public VolumeInfo volumeInfo;
    public SaleInfo saleInfo;
    public AccessInfo accessInfo;
}

public class Result {
    public String kind;
    public int totalItems;
    public ArrayList<Item> items;

    public List<VolumeInfo> getVolumes() {
        List<VolumeInfo> list = new ArrayList<>();
        for (Item item: items) {
            list.add(item.volumeInfo);
        }
        return list;
    }
}


