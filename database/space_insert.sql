-- Active: 1688044672103@@127.0.0.1@3306@space

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
        false
    ), (
        "Extracteur d'Hydrogène",
        'Récolte',
        "Un extracteur permettant d'obtenir de l'hydrogène à partir de n'importe quelle atmosphère",
        0,
        300,
        300,
        300,
        0,
        1,
        false
    ), (
        'Mine de Diamant',
        'Récolte',
        'Une mine permettant de récolter du diamant',
        0,
        600,
        600,
        600,
        0,
        1,
        false
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
        false
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
        false
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
        false
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
        false
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
        1,
        200,
        200,
        200,
        0,
        1,
        false
    ), (
        'Chantier spatial',
        'Production',
        "Partez dans l'espace ! Débloque le chantier spatial.",
        2,
        1000,
        1000,
        1000,
        0,
        1,
        false
    ), (
        'Laboratoire',
        'Production',
        "Un laboratoire très bien équipé permettant de débloquer l'accès aux recherches",
        3,
        50,
        50,
        50,
        0,
        1,
        false
    ), (
        'Terraformeur',
        'Production',
        "Rend la planète habitable, permettant d'augmenter sa capacité",
        4,
        5000,
        5000,
        5000,
        0,
        1,
        false
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
        iron_price,
        hydrogen_price,
        diamond_price,
        energy_price,
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
        level,
        time_search,
        time_to_start,
        iron_price,
        hydrogen_price,
        diamond_price,
        energy_price,
        is_done,
        coef_modifier
    )
VALUES (
        'Technologie cargo',
        'Augmente la capacité des vaisseaux de transport',
        0,
        NOW(),
        NOW(),
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
        NOW(),
        NOW(),
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
        NOW(),
        NOW(),
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
        NOW(),
        NOW(),
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
        NOW(),
        NOW(),
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
        NOW(),
        NOW(),
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
        NOW(),
        NOW(),
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
        NOW(),
        NOW(),
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
        NOW(),
        NOW(),
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
        NOW(),
        NOW(),
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
        NOW(),
        NOW(),
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
        NOW(),
        NOW(),
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
        NOW(),
        NOW(),
        200,
        200,
        200,
        0,
        0,
        1
    );

insert into
    ressource (id, name, quantity, max_stock)
values (1, 'diamond', 4000, 10000), (2, 'iron', 4000, 10000), (3, 'hydrogene', 4000, 10000), (4, 'energy', 4000, 10000);

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