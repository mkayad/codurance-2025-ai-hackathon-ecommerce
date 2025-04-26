<!DOCTYPE html>
<html>
<head>
    <title>Fashion Items</title>
    <style>
        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }
        .filter-container {
            margin-bottom: 20px;
        }
        .filter-select {
            padding: 8px;
            font-size: 16px;
            border-radius: 4px;
            border: 1px solid #ddd;
        }
        .item-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
            gap: 20px;
            padding: 20px;
        }
        .item-card {
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 15px;
            background: white;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            transition: transform 0.2s;
        }
        .item-card:hover {
            transform: translateY(-5px);
        }
        .item-name {
            font-size: 1.2em;
            margin: 10px 0;
            color: #333;
        }
        .item-category {
            color: #666;
            font-size: 0.9em;
            padding: 5px 10px;
            background: #f5f5f5;
            border-radius: 4px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Fashion Items</h1>
        
        <!-- Category Filter -->
        <div class="filter-container">
            <select class="filter-select" id="categoryFilter" onchange="filterByCategory()">
                <option value="">All Categories</option>
                <#list fashionItems as item>
                    <#if item.masterCategory??>
                        <option value="${item.masterCategory}" 
                                <#if item.masterCategory == filterCategory>selected</#if>>
                            ${item.masterCategory}
                        </option>
                    </#if>
                </#list>
            </select>
        </div>

        <div class="item-grid" id="itemGrid">
            <#list fashionItems as item>
                <#if filterCategory == "" || item.masterCategory == filterCategory>
                    <div class="item-card">
                        <div class="item-category">${item.masterCategory}</div>
                        <h2 class="item-name">${item.productDisplayName}</h2>
                    </div>
                </#if>
            </#list>
        </div>
    </div>

    <script>
        let filterCategory = "";

        function filterByCategory() {
            filterCategory = document.getElementById('categoryFilter').value;
            window.location.href = `/fashion?category=${filterCategory}`;
        }
    </script>
</body>
</html>
