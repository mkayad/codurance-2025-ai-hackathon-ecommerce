<!DOCTYPE html>
<html>
<head>
    <title>Fashion Items</title>
    <style>
        .item-card {
            border: 1px solid #ddd;
            padding: 15px;
            margin: 15px;
            border-radius: 5px;
            width: 300px;
        }
        .item-image {
            width: 200px;
            height: 200px;
            object-fit: cover;
        }
        .item-price {
            color: #2ecc71;
            font-weight: bold;
            font-size: 1.2em;
        }
    </style>
</head>
<body>
    <h1>Fashion Items</h1>
    <div class="item-grid">
        <#list fashionItems as item>
            <div class="item-card">
                <img class="item-image" src="${item.imageUrl}" alt="${item.name}">
                <h2>${item.name}</h2>
                <p>${item.description}</p>
                <div class="item-price">$${item.price}</div>
            </div>
        </#list>
    </div>
</body>
</html>
