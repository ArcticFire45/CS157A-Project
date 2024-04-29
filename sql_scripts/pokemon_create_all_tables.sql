use pokemon_trader;
CREATE TABLE IF NOT EXISTS Users (
    UserID INT PRIMARY KEY,
    Password VARCHAR(255),
    Money DECIMAL(10, 2)
);

CREATE TABLE IF NOT EXISTS PokemonTemplate(
	PokeTemplateID INT PRIMARY KEY,
    PokeName VARCHAR(255) NOT NULL,
    Type1 VARCHAR(50) NOT NULL,
    Type2 VARCHAR(50),
    GifURL VARCHAR(255) NOT NULL,
    ImageURL VARCHAR(255) NOT NULL,
    PokemonDescription TEXT
);
CREATE TABLE IF NOT EXISTS ItemTemplate(
	ItemTemplateID INT PRIMARY KEY,
    ItemName VARCHAR(255) NOT NULL,
    ItemDescription Text,
    MoneyClickerMultiplier FLOAT NOT NULL,
	ImageURL VARCHAR(255) NOT NULL,
    CHECK (MoneyClickerMultiplier >= 1) 
);


CREATE TABLE IF NOT EXISTS Pokemon (
    PokeID INT PRIMARY KEY, -- The pokemon identity
    UserID INT, -- Pokemon owner
    PokeTemplateID INT NOT NULL, -- Pokemon type
    FOREIGN KEY (UserID) REFERENCES Users(UserID),
    FOREIGN KEY (PokeTemplateID) REFERENCES PokemonTemplate(PokeTemplateID)
);

CREATE TABLE IF NOT EXISTS PokemonTeam (
    UserID INT PRIMARY KEY,
    PokemonID1 INT,
    PokemonID2 INT,
    PokemonID3 INT,
    PokemonID4 INT,
    PokemonID5 INT,
    PokemonID6 INT,
    FOREIGN KEY (UserID) REFERENCES Users(UserID),
    FOREIGN KEY (PokemonID1) REFERENCES Pokemon(PokeID),
    FOREIGN KEY (PokemonID2) REFERENCES Pokemon(PokeID),
    FOREIGN KEY (PokemonID3) REFERENCES Pokemon(PokeID),
    FOREIGN KEY (PokemonID4) REFERENCES Pokemon(PokeID),
    FOREIGN KEY (PokemonID5) REFERENCES Pokemon(PokeID),
    FOREIGN KEY (PokemonID6) REFERENCES Pokemon(PokeID)
);

-- CREATE TABLE IF NOT EXISTS PokemonInventory (
--     UserID INT,
--     PokeID INT,
--     FOREIGN KEY (UserID) REFERENCES Users(UserID),
--     FOREIGN KEY (PokeID) REFERENCES Pokemon(PokeID)
-- );

CREATE TABLE IF NOT EXISTS Items (
    ItemID INT PRIMARY KEY,
    UserID INT,
    ItemTemplateID INT NOT NULL,
    FOREIGN KEY (UserID) REFERENCES Users(UserID),
    FOREIGN KEY (ItemTemplateID) REFERENCES ItemTemplate(ItemTemplateID)
);

-- CREATE TABLE IF NOT EXISTS ItemInventory (
--     UserID INT,
--     ItemID INT,
--     FOREIGN KEY (UserID) REFERENCES Users(UserID),
--     FOREIGN KEY (ItemID) REFERENCES Items(ItemID)
-- );

CREATE TABLE IF NOT EXISTS Sales (
    SalesID INT PRIMARY KEY,
    Seller INT NOT NULL,
    Purchaser INT,
    Price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (Seller) REFERENCES Users(UserID),
    FOREIGN KEY (Purchaser) REFERENCES Users(UserID),
    CHECK (Price >= 0) 
);

CREATE TABLE IF NOT EXISTS PokemonSales (
    SalesID INT PRIMARY KEY,
    PokemonID INT NOT NULL,
    FOREIGN KEY (SalesID) REFERENCES Sales(SalesID),
    FOREIGN KEY (PokemonID) REFERENCES Pokemon(PokeID)
);

CREATE TABLE IF NOT EXISTS ItemSales (
    SalesID INT PRIMARY KEY,
    ItemID INT NOT NULL,
    FOREIGN KEY (SalesID) REFERENCES Sales(SalesID),
    FOREIGN KEY (ItemID) REFERENCES Items(ItemID)
);

CREATE TABLE IF NOT EXISTS Posts (
    PostID INT PRIMARY KEY,
    PostDescription VARCHAR(255) NOT NULL,
    ImageURL VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS UserPosts (
    UserID INT NOT NULL,
    PostID INT PRIMARY KEY,
    FOREIGN KEY (UserID) REFERENCES Users(UserID),
    FOREIGN KEY (PostID) REFERENCES Posts(PostID)
);

CREATE TABLE IF NOT EXISTS SalesPosts (
    SalesID INT NOT NULL,
    PostID INT PRIMARY KEY,
    FOREIGN KEY (SalesID) REFERENCES Sales(SalesID),
    FOREIGN KEY (PostID) REFERENCES Posts(PostID)
);

CREATE TABLE IF NOT EXISTS Friends (
    UserID1 INT NOT NULL,
    UserID2 INT NOT NULL,
    PRIMARY KEY (UserID1, UserID2),
    FOREIGN KEY (UserID1) REFERENCES Users(UserID),
    CHECK (UserID1 != UserID2)
);

CREATE TABLE IF NOT EXISTS ActivityWall (
    UserID INT PRIMARY KEY,
    PostID INT NOT NULL,
    FOREIGN KEY (UserID) REFERENCES Users(UserID),
    FOREIGN KEY (PostID) REFERENCES Posts(PostID)
);
