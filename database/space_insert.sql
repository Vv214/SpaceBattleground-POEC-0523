-- Active: 1690547072753@@127.0.0.1@3306@space

USE space;

DROP space;

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
        coeff_prod
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
        1
    ), (
        "Extracteur d'Hydrogène",
        'Récolte',
        "Un extracteur permettant d'obtenir de l'hydrogène à partir de n'importe quelle atmosphère",
        0,
        200,
        200,
        200,
        0,
        1
    ), (
        'Mine de Diamant',
        'Récolte',
        'Une mine permettant de récolter du diamant',
        0,
        200,
        200,
        200,
        0,
        1
    ), (
        'Centrale électrique',
        'Récolte',
        "Produit de l'énergie grâce au soleil",
        0,
        200,
        200,
        200,
        0,
        1
    ), (
        'Hangar de fer',
        'Récolte',
        'Permet de stocker plus de fer',
        0,
        200,
        200,
        200,
        0,
        1
    ), (
        "Hangar d'hydrogène",
        'Récolte',
        "Permet de stocker plus d'hydrogène",
        0,
        200,
        200,
        200,
        0,
        1
    ), (
        'Hangar de diamants',
        'Récolte',
        'Permet de stocker plus de diamant',
        0,
        200,
        200,
        200,
        0,
        1
    ), (
        'Foreuse',
        'Récolte',
        "Permet d'augmenter la production de fer, hydrogène et diamant de x %",
        0,
        200,
        200,
        200,
        0,
        1
    ), (
        'Usine de robots',
        'Production',
        'Construit des robots qui à leur tour accélèrent la vitesse de construction des bâtiments et des vaisseaux',
        0,
        200,
        200,
        200,
        0,
        1
    ), (
        'Chantier spatial',
        'Production',
        "Partez dans l'espace ! Débloque le chantier spatial.",
        0,
        200,
        200,
        200,
        0,
        1
    ), (
        'Laboratoire',
        'Production',
        "Un laboratoire très bien équipé permettant de débloquer l'accès aux recherches",
        0,
        200,
        200,
        200,
        0,
        1
    ), (
        'Terraformeur',
        'Production',
        "Rend la planète habitable, permettant d'augmenter sa capacité",
        0,
        200,
        200,
        200,
        0,
        1
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
    ressource (id, name, quantity, max_stock)
values (1, 'diamond', 42, 250), (2, 'iron', 25, 470), (3, 'hydrogene', 258, 579), (4, 'energy', 135, 258);

insert into
    planet (
        name,
        is_colonised,
        positionx,
        positiony,
        planet_size
    )
values ("Cygnus", true, 1, 1, 100), ("Elysium", false, 2, 6, 500), ("Nova Prime", false, 3, 17, 500), ("Arkanis", true, 1, 12, 100), ("Umbra", false, 4, 19, 50), ("Nox", false, 5, 18, 50), ("Eclipsia", false, 5, 16, 50), ("Zephyria", false, 12, 19, 100), ("Pandora", false, 17, 17, 500), ("Aquilon", false, 20, 20, 100), ("Alpha", false, 18, 14, 100), ("Titanis", false, 13, 19, 500), ("Titanis-9", true, 10, 19, 100), ("Solaris", false, 8, 8, 100), ("Edenia", false, 2, 6, 500), ("Xerion", true, 2, 3, 100), ("Nereida", false, 5, 3, 50), ("Aetheria", false, 6, 2, 500), ("Lyra", false, 11, 2, 100), ("Terra Nova", true, 12, 6, 500), ("Rhea", false, 14, 6, 50), ("Seren", false, 18, 1, 500);

insert into
    clan (
        clan_name,
        clan_tag,
        level,
        current_number_players,
        number_max_players,
        admin_nickname
    )
values (
        "Solarium",
        "SOL",
        10,
        12,
        50,
        "Thane"
    ), (
        "Les Héros d'Aquilon",
        "AQU",
        25,
        8,
        50,
        "Tiberius"
    ), (
        "Lunarium",
        "LUN",
        10,
        10,
        50,
        "Nyx"
    ), (
        "Empire Galactique d'Orion",
        "EGO",
        99,
        50,
        50,
        "Alzuran"
    );