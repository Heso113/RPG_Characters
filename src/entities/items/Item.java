package entities.items;

import entities.attributes.BaseAttributes;

public abstract class Item extends BaseAttributes {
    private ItemType itemType;

    public void setItemType(ItemType type) {
        this.itemType = type;
    }

    public ItemType getItemType() {
        return this.itemType;
    }  
}
