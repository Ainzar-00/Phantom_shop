package com.example.tp_synthese_ui

val products=mutableMapOf<String,MutableList<Produit>>(productsname.HEADPHONES.name to mutableListOf(
    Produit(
        id = 1,
        title = "Wireless Headphones A1",
        description = "Over-ear wireless headphones with noise cancellation.",
        price = 79.99,
        imageRes = R.drawable.headphone1
    ),
    Produit(
        id = 2,
        title = "Wireless Headphones B2",
        description = "Compact on-ear headphones with deep bass.",
        price = 59.99,
        imageRes = R.drawable.headphone2

    ),
    Produit(
        id = 3,
        title = "Wireless Headphones C3",
        description = "Sport headphones, sweat-resistant with long battery life.",
        price = 69.99,
        imageRes = R.drawable.headphone3

    )
),productsname.MICROPHONES.name to mutableListOf(
    Produit(
        id = 1,
        title = "Studio Microphone M1",
        description = "Professional condenser mic with crystal-clear voice capture.",
        price = 129.99,
        imageRes = R.drawable.micro1
    ),
    Produit(
        id = 2,
        title = "USB Microphone M2",
        description = "Plug-and-play USB mic ideal for streaming and podcasts.",
        price = 79.99,
        imageRes = R.drawable.micro2
    ),
    Produit(
        id = 3,
        title = "Wireless Microphone M3",
        description = "Wireless mic with stable connection and excellent clarity.",
        price = 149.99,
        imageRes = R.drawable.micro3
    )
),productsname.CAMERA.name to mutableListOf(
    Produit(
        id = 1,
        title = "Digital Camera C1",
        description = "Compact digital camera with sharp image quality.",
        price = 249.99,
        imageRes = R.drawable.camera1
    ),
    Produit(
        id = 2,
        title = "Professional Camera C2",
        description = "High-performance DSLR for detailed photos and videos.",
        price = 699.99,
        imageRes = R.drawable.camera2
    ),
    Produit(
        id = 3,
        title = "Action Camera C3",
        description = "Durable 4K action cam perfect for sports and travel.",
        price = 199.99,
        imageRes = R.drawable.camera3
    )
)
    , productsname.CLAVIER.name to mutableListOf(
        Produit(
            id = 1,
            title = "Mechanical Keyboard K1",
            description = "RGB mechanical keyboard with tactile switches.",
            price = 79.99,
            imageRes = R.drawable.clavier1
        ),
        Produit(
            id = 2,
            title = "Wireless Keyboard K2",
            description = "Slim wireless keyboard with long battery life.",
            price = 49.99,
            imageRes = R.drawable.clavier2
        ),
        Produit(
            id = 3,
            title = "Ergonomic Keyboard K3",
            description = "Comfort-focused ergonomic keyboard for long work sessions.",
            price = 69.99,
            imageRes = R.drawable.clavier3
    )
    ),productsname.PC.name to mutableListOf(
        Produit(
            id = 1,
            title = "Gaming PC G1",
            description = "High-performance gaming PC with powerful graphics.",
            price = 1299.99,
            imageRes = R.drawable.pc1
        ),
        Produit(
            id = 2,
            title = "Workstation PC W2",
            description = "Reliable workstation ideal for programming and multitasking.",
            price = 899.99,
            imageRes = R.drawable.pc2
        ),
        Produit(
            id = 3,
            title = "Mini PC M3",
            description = "Compact and silent mini PC for daily use.",
            price = 499.99,
            imageRes = R.drawable.pc3
        )
    )


)