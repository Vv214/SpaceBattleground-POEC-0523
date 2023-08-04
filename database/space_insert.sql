USE space;

INSERT INTO
    building (
        name,
        type,
        description,
        level,
        iron_price,
        hydrogen_price,
        diamond_price,
        energy_price,
        coeff_prod,
        is_build
    )
VALUES (
        'Mine de fer',
        'Récolte',
        "Une mine permettant de récolter du fer",
        0,
        200,
        200,
        200,
        0,
        1,
        true
    ), (
        "Extracteur d'Hydrogène",
        'Récolte',
        "Un extracteur permettant d'obtenir de l'hydrogène à partir de n'importe quelle atmosphère",
        0,
        200,
        200,
        200,
        0,
        1,
        true
    ), (
        'Mine de Diamant',
        'Récolte',
        'Une mine permettant de récolter du diamant',
        0,
        200,
        200,
        200,
        0,
        1,
        true
    ), (
        'Centrale électrique',
        'Récolte',
        "Produit de l'énergie grâce au soleil",
        0,
        200,
        200,
        200,
        0,
        1,
        true
    ), (
        'Hangar de fer',
        'Récolte',
        'Permet de stocker plus de fer',
        0,
        200,
        200,
        200,
        0,
        1,
        true
    ), (
        "Hangar d'hydrogène",
        'Récolte',
        "Permet de stocker plus d'hydrogène",
        0,
        200,
        200,
        200,
        0,
        1,
        true
    ), (
        'Hangar de diamants',
        'Récolte',
        'Permet de stocker plus de diamant',
        0,
        200,
        200,
        200,
        0,
        1,
        true
    ), (
        'Foreuse',
        'Récolte',
        "Permet d'augmenter la production de fer, hydrogène et diamant de x %",
        0,
        200,
        200,
        200,
        0,
        1,
        true
    ), (
        'Usine de robots',
        'Production',
        'Construit des robots qui à leur tour accélèrent la vitesse de construction des bâtiments et des vaisseaux',
        0,
        200,
        200,
        200,
        0,
        1,
        true
    ), (
        'Chantier spatial',
        'Production',
        "Partez dans l'espace ! Débloque le chantier spatial.",
        0,
        200,
        200,
        200,
        0,
        1,
        true
    ), (
        'Laboratoire',
        'Production',
        "Un laboratoire très bien équipé permettant de débloquer l'accès aux recherches",
        0,
        200,
        200,
        200,
        0,
        1,
        true
    ), (
        'Terraformeur',
        'Production',
        "Rend la planète habitable, permettant d'augmenter sa capacité",
        0,
        200,
        200,
        200,
        0,
        1,
        true
    );

INSERT INTO
    ship (
        name,
        type,
        pv,
        damage,
        speed,
        capacity,
        fuel,
        ship_size,
        iron_price,
        hydrogen_price,
        diamond_price,
        price_energy,
        quantity
    )
VALUES (
        'Chasseur léger',
        'Combat',
        100,
        100,
        3,
        0,
        100,
        2,
        200,
        200,
        200,
        0,
        0
    ), (
        'Chasseur lourd',
        'Combat',
        500,
        100,
        2,
        0,
        150,
        4,
        400,
        200,
        200,
        0,
        0
    ), (
        'Destroyer',
        'Combat',
        3000,
        500,
        1,
        0,
        300,
        30,
        2000,
        2000,
        2000,
        0,
        0
    ), (
        'Eclaireur',
        'Combat',
        50,
        50,
        4,
        0,
        100,
        2,
        100,
        100,
        100,
        0,
        0
    ), (
        'Transporteur léger',
        'Civil',
        50,
        10,
        2,
        600,
        100,
        5,
        200,
        200,
        200,
        0,
        0
    ), (
        'Transporteur lourd',
        'Civil',
        100,
        20,
        1,
        1800,
        150,
        10,
        200,
        200,
        200,
        0,
        0
    ), (
        'Récolteur',
        'Civil',
        50,
        10,
        2,
        300,
        100,
        10,
        300,
        200,
        200,
        0,
        0
    ), (
        'Colonisateur',
        'Civil',
        200,
        0,
        1,
        0,
        100,
        15,
        200,
        200,
        200,
        0,
        0
    );

INSERT INTO
    technologie (
        name,
        description,
        lvl,
        time_search,
        iron_price,
        hydrogen_price,
        diamond_price,
        price_energy,
        is_done,
        coef_modifier
    )
VALUES (
        'Technologie cargo',
        'Augmente la capacité des vaisseaux de transport',
        0,
        1,
        200,
        200,
        200,
        0,
        0,
        1
    ), (
        'Réacteur à combustion',
        'Augmente la vitesse des vaisseaux',
        0,
        1,
        200,
        200,
        200,
        0,
        0,
        1
    ), (
        'Réacteur à impulsion',
        'Augmente beaucoup la vitesse des vaisseaux',
        0,
        1,
        200,
        200,
        200,
        0,
        0,
        1
    ), (
        'Coques améliorées',
        'Augmente les PV des vaisseaux',
        0,
        1,
        200,
        200,
        200,
        0,
        0,
        1
    ), (
        'Astrophysique',
        'Augmente le nombre de planètes colonisables',
        0,
        1,
        200,
        200,
        200,
        0,
        0,
        1
    ), (
        'Technologie Armes à feu',
        'Augmente les dégâts des vaisseaux de combat',
        0,
        1,
        200,
        200,
        200,
        0,
        0,
        1
    ), (
        'Technologie Armes laser',
        'Augmente beaucoup les dégâts des vaisseaux de combat',
        0,
        1,
        200,
        200,
        200,
        0,
        0,
        1
    ), (
        'Technologie flotte',
        'Augmente le nombre de flottes',
        0,
        1,
        200,
        200,
        200,
        0,
        0,
        1
    ), (
        'Technologie plasma',
        'Augmente la production de ressources',
        0,
        1,
        200,
        200,
        200,
        0,
        0,
        1
    ), (
        'Technologie énergétique',
        "Augmente la production d'énergie",
        0,
        1,
        200,
        200,
        200,
        0,
        0,
        1
    ), (
        'Mine de fer améliorée',
        "Ajoute 10 niveaux d'amélioration",
        0,
        1,
        200,
        200,
        200,
        0,
        0,
        1
    ), (
        "Extracteur d'hydrogène amélioré",
        "Ajoute 10 niveaux d'amélioration",
        0,
        1,
        200,
        200,
        200,
        0,
        0,
        1
    ), (
        'Mine de diamant améliorée',
        "Ajoute 10 niveaux d'amélioration",
        0,
        1,
        200,
        200,
        200,
        0,
        0,
        1
    );

insert into
    ressource (name, quantity, max_stock)
values ('diamond', 42, 250), ('iron', 25, 470), ('hydrogene', 258, 579), ('energy', 135, 258);