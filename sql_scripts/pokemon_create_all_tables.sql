use pokemon_trader;
CREATE TABLE IF NOT EXISTS Users (
    Username varchar(30) PRIMARY KEY,
    User_Password VARCHAR(255),
    Money DECIMAL(10, 2),
    CHECK (money >= 0)
);

CREATE TABLE IF NOT EXISTS PokemonTemplate(
	PokeTemplateID INT PRIMARY KEY auto_increment,
    StockPrice DECIMAL(10, 2) NOT NULL,
    PokeName VARCHAR(255) NOT NULL,
    Type1 VARCHAR(50) NOT NULL,
    Type2 VARCHAR(50),
    GifURL VARCHAR(255) NOT NULL,
    ImageURL VARCHAR(255) NOT NULL,
    PokemonDescription TEXT
);

CREATE TABLE IF NOT EXISTS ItemTemplate(
	ItemTemplateID INT PRIMARY KEY auto_increment,
    ItemName VARCHAR(255) NOT NULL,
    StockPrice DECIMAL(10,2) NOT NULL,
    ItemDescription Text,
    MoneyClickerMultiplier FLOAT NOT NULL,
	ImageURL VARCHAR(255) NOT NULL,
    CHECK (MoneyClickerMultiplier >= 1) 
);


CREATE TABLE IF NOT EXISTS Pokemon (
    PokeID INT PRIMARY KEY auto_increment, -- The pokemon identity
    Username varchar(30), -- Pokemon owner
    PokeTemplateID INT NOT NULL, -- Pokemon type
    FOREIGN KEY (Username) REFERENCES Users(Username) ON DELETE CASCADE,
    FOREIGN KEY (PokeTemplateID) REFERENCES PokemonTemplate(PokeTemplateID) ON DELETE CASCADE
);



CREATE TABLE IF NOT EXISTS PokemonTeam ( -- needs to check that PokemonID's owner is UserID in Pokemon
    Username varchar(30) PRIMARY KEY,
    PokemonID1 INT,
    PokemonID2 INT,
    PokemonID3 INT,
    PokemonID4 INT,
    PokemonID5 INT,
    PokemonID6 INT,
    FOREIGN KEY (Username) REFERENCES Users(Username) ON DELETE CASCADE,
    FOREIGN KEY (PokemonID1) REFERENCES Pokemon(PokeID) ON DELETE CASCADE,
    FOREIGN KEY (PokemonID2) REFERENCES Pokemon(PokeID) ON DELETE CASCADE,
    FOREIGN KEY (PokemonID3) REFERENCES Pokemon(PokeID) ON DELETE CASCADE,
    FOREIGN KEY (PokemonID4) REFERENCES Pokemon(PokeID) ON DELETE CASCADE,
    FOREIGN KEY (PokemonID5) REFERENCES Pokemon(PokeID) ON DELETE CASCADE,
    FOREIGN KEY (PokemonID6) REFERENCES Pokemon(PokeID) ON DELETE CASCADE,
    CONSTRAINT noSamePokemon UNIQUE (PokemonID1,PokemonID2,PokemonID3,PokemonID4,PokemonID5,PokemonID6)
);


-- CREATE TABLE IF NOT EXISTS PokemonInventory (
--     Username INT,
--     PokeID INT,
--     FOREIGN KEY (Username) REFERENCES Users(Username),
--     FOREIGN KEY (PokeID) REFERENCES Pokemon(PokeID)
-- );

CREATE TABLE IF NOT EXISTS Items ( 
	ItemID INT PRIMARY KEY auto_increment,
    Username varchar(30),
    ItemTemplateID INT NOT NULL,
    FOREIGN KEY (Username) REFERENCES Users(Username),
    FOREIGN KEY (ItemTemplateID) REFERENCES ItemTemplate(ItemTemplateID)
);

-- CREATE TABLE IF NOT EXISTS ItemInventory (
--     Username INT,
--     ItemID INT,
--     FOREIGN KEY (Username) REFERENCES Users(Username),
--     FOREIGN KEY (ItemID) REFERENCES Items(ItemID)
-- );

CREATE TABLE IF NOT EXISTS Sales (
    SalesID INT PRIMARY KEY auto_increment,
    Seller varchar(30),
    Purchaser varchar(30),
    Price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (Seller) REFERENCES Users(Username) ON DELETE CASCADE,
    FOREIGN KEY (Purchaser) REFERENCES Users(Username) ON DELETE CASCADE,
    CHECK (Price >= 0) 
);

CREATE TABLE IF NOT EXISTS PokemonSales (
    SalesID INT PRIMARY KEY,
    PokemonID INT NOT NULL,
    FOREIGN KEY (SalesID) REFERENCES Sales(SalesID) ON DELETE CASCADE,
    FOREIGN KEY (PokemonID) REFERENCES Pokemon(PokeID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS ItemSales (
    SalesID INT PRIMARY KEY,
    ItemID INT NOT NULL,
    FOREIGN KEY (SalesID) REFERENCES Sales(SalesID) ON DELETE CASCADE,
    FOREIGN KEY (ItemID) REFERENCES Items(ItemID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS UserPosts (
	PostID INT PRIMARY KEY auto_increment,
    Author varchar(30) NOT NULL,
    PostDescription VARCHAR(255) NOT NULL,
    ImageURL VARCHAR(255),
    FOREIGN KEY (Author) REFERENCES Users(Username) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS SalesPosts (
    SalesID INT NOT NULL,
    PostID INT PRIMARY KEY,
    FOREIGN KEY (SalesID) REFERENCES Sales(SalesID) ON DELETE CASCADE,
    FOREIGN KEY (PostID) REFERENCES UserPosts(PostID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Friends (
    Username1 varchar(30) NOT NULL,
    Username2 varchar(30) NOT NULL,
    PRIMARY KEY (Username1, Username2),
    FOREIGN KEY (Username1) REFERENCES Users(Username) ON DELETE CASCADE,
    FOREIGN KEY (Username2) REFERENCES Users(Username) ON DELETE CASCADE,
    CHECK (Username1 != Username2)
);

-- CREATE TABLE IF NOT EXISTS ActivityWall (
--     Username varchar(30),
--     PostID INT NOT NULL,
--     primary key (Username, PostID),
--     FOREIGN KEY (Username) REFERENCES Users(Username),
--     FOREIGN KEY (PostID) REFERENCES UserPosts(PostID)
-- );

-- CREATE TABLE IF NOT EXISTS SalesWall (
--     Username varchar(30),
--     PostID INT NOT NULL,
-- 	primary key (Username, PostID),
--     FOREIGN KEY (Username) REFERENCES Users(Username),
--     FOREIGN KEY (PostID) REFERENCES SalesPosts(PostID)
-- );
