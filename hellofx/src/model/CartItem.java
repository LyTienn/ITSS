package model;

public class CartItem {
    private Media media;
    private int quantity;

    public CartItem(Media media, int quantity) {
        this.media = media;
        this.quantity = quantity;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return media.getPrice() * quantity;
    }
}
