package com.example.springboot;

// CREATE TABLE IF NOT EXISTS Items (
//     ItemID INT PRIMARY KEY auto_increment,
//     Username varchar(30),
//     ItemTemplateID INT NOT NULL,
//     FOREIGN KEY (Username) REFERENCES Users(Username),
//     FOREIGN KEY (ItemTemplateID) REFERENCES ItemTemplate(ItemTemplateID)
// );
public class ExistingItem {
    private Integer item_id;
    private String username;
    private Integer item_template_id;
    private Items item_template;

    public ExistingItem(Integer item_id, String username, Integer item_template_id) {
        this.item_id = item_id;
        this.username = username;
        this.item_template_id = item_template_id;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getItem_template_id() {
        return item_template_id;
    }

    public void setItem_template_id(Integer item_template_id) {
        this.item_template_id = item_template_id;
    }

    @Override
    public String toString() {
        return "ExistingItem [item_id=" + item_id + ", username=" + username + ", item_template_id=" + item_template_id
                + "]";
    }

    public Items getItem_template() {
        return item_template;
    }

    public void setItem_template(Items item_template) {
        this.item_template = item_template;
    }
}
