package com.example.capstoneproject.data.databasepages

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewModelScope
import com.example.capstoneproject.data.database.CapstoneViewModel
import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.restaurant.Restaurant
import com.example.capstoneproject.data.database.user.User
import kotlinx.coroutines.launch

class ToInsert {
    @Suppress("ktlint:standard:function-naming")
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun InsertUI(capstoneViewModel: CapstoneViewModel) {
        val restId = 1

        Scaffold {
            Column {
                Button(
                    onClick = {
                        capstoneViewModel.viewModelScope.launch {
                            capstoneViewModel.insertUser(User("Test User"))
                        }
                    },
                ) {
                    Text("User")
                }
                // Button(
                //    onClick = {
                //        capstoneViewModel.viewModelScope.launch {
                //            capstoneViewModel.deleteUserById(4)
                //        }
                //    }) {
                //    Text("delete")
                // }

                Button(
                    onClick = {
                        capstoneViewModel.viewModelScope.launch {
                            //Halal
                            //Malaysian Cuisine
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "Bunga Raya Halal Kitchen",
                                    "Halal"
                                )
                            )
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "Seri Melayu Bistro",
                                    "Halal"
                                )
                            )

                            //Japanese Cuisine
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "Sushi Sakura Halal",
                                    "Halal"
                                )
                            )
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "Zen Ramen & Teppanyaki Halal",
                                    "Halal"
                                )
                            )

                            //Western Cuisine
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "Sultan's Bistro",
                                    "Halal"
                                )
                            )
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "Medina Grill & Steakhouse",
                                    "Halal"
                                )
                            )


                            //Non-halal
                            //Chinese
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "Dragon's Delight",
                                    "Non-Halal"
                                )
                            )
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "Imperial Dragon Palace",
                                    "Non-Halal"
                                )
                            )
                            //Korean
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "Seoul Sizzle BBQ House",
                                    "Non-Halal"
                                )
                            )
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "Kimchi King's Kitchen",
                                    "Non-Halal"
                                )
                            )
                            //Thai
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "Fiery Thai Bites",
                                    "Non-Halal"
                                )
                            )
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "Bangkok Spice Haven",
                                    "Non-Halal"
                                )
                            )

                            //Vegan
                            //American
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "Green Bliss Café",
                                    "Vegan"
                                )
                            )
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "Herbivore Haven",
                                    "Vegan"
                                )
                            )

                            //Asian
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    " Lotus Bites",
                                    "Vegan"
                                )
                            )
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "Zen Garden Vegan Kitchen",
                                    "Vegan"
                                )
                            )

                            //Indian
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "Spice Haven Vegan Bistro",
                                    "Vegan"
                                )
                            )
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "Green Leaf Masala House",
                                    "Vegan"
                                )
                            )


                            //Vegetarian
                            //East Asian
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "ZenBite Vegetarian Delights",
                                    "Vegetarian"
                                )
                            )
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "Lotus Leaf Vegetarian Haven",
                                    "Vegetarian"
                                )
                            )

                            //Fusion
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "Harmony Bites",
                                    "Vegetarian"
                                )
                            )
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "Veggie Fusion Delights",
                                    "Vegetarian"
                                )
                            )
                            //Western
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "Sage & Saffron",
                                    "Vegetarian"
                                )
                            )
                            capstoneViewModel.insertRestaurant(
                                Restaurant(
                                    "Green Haven Grill",
                                    "Vegetarian"
                                )
                            )

                            // capstoneViewModel.deleteRestaurant(15)
                        }
                    },
                ) {
                    Text("Add Restaurant")
                }

                Button(
                    onClick = {
                        addHalalFood(capstoneViewModel)
                        addNonHalalFood(capstoneViewModel)
                        addVeganFood(capstoneViewModel)
                        addVegetarianFood(capstoneViewModel)
                    },
                ) {
                    Text("Add Food")
                }

                Button(
                    onClick = {
                        capstoneViewModel.viewModelScope.launch {
                        }
                    },
                ) {
                    Text("Update Food")
                }

                Button(
                    onClick = {
                        capstoneViewModel.viewModelScope.launch {
                            val listCount: List<Int> = listOf(55, 56, 57)
                            listCount.forEach { count ->
                                capstoneViewModel.deleteUserFav(count)
                            }
                        }
                    },
                ) {
                    Text("Delete User fav")
                }
            }
        }
    }

    private fun addVegetarianFood(capstoneViewModel: CapstoneViewModel) {
        capstoneViewModel.viewModelScope.launch {
            //restaurant 13
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Quinoa Avocado Salad",
                    foodPrice = 12.99,
                    foodCategory = "American Vegan Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1152434878/photo/buddha-bowl-with-grilled-avocado-asparagus-chickpeas-pea-sprouts-and-broccoli.jpg?s=612x612&w=is&k=20&c=chy_4TasNGHbOt2vxSKLYCQi660uEn7rtGEs7Omhtvs=",
                    restaurantId = 13
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "BBQ Jackfruit Sandwich",
                    foodPrice = 14.49,
                    foodCategory = "American Vegan Cuisine",
                    foodImage = "https://media.istockphoto.com/id/526283108/photo/homemade-vegan-pulled-jackfruit-bbq-sandwich.jpg?s=612x612&w=is&k=20&c=Ozo1E4OIejnwhRee75yiWwGKWL4Ou2MoCgw-2jj5tOo=",
                    restaurantId = 13
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Vegan Mac and Cheese",
                    foodPrice = 11.99,
                    foodCategory = "American Vegan Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1351652207/photo/vegan-white-mac-and-cheese-with-a-glass-of-wine.jpg?s=612x612&w=is&k=20&c=w2XoP6QgR3i7tJddtKSsXiBqW7P1-9k7S4XOG9BCmQA=",
                    restaurantId = 13
                )
            )
            //restaurant 14
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Mushroom Lentil Shepherd's Pie",
                    foodPrice = 11.99,
                    foodCategory = "American Vegan Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1255601380/photo/vegan-lentil-and-mushroom-shepherds-pie.jpg?s=612x612&w=is&k=20&c=YMSyzRlbjSCypkTSf-coLB-3Jb-qEvgJoJVWzPa5X3k=",
                    restaurantId = 14
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Mushroom Walnut Tacos",
                    foodPrice = 11.99,
                    foodCategory = "American Vegan Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1152509492/photo/vegan-and-vegetarian-mexican-mushrooms-tacos-with-sauce-and-lime.jpg?s=612x612&w=is&k=20&c=qCoR7dpnxkAfMW3FvxYd17T-5VTZdykWcEaW5Kk8-RE=",
                    restaurantId = 14
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Southwest Vegan Bowl",
                    foodPrice = 10.99,
                    foodCategory = "American Vegan Cuisine",
                    foodImage = "https://media.istockphoto.com/id/920020000/photo/mexican-tomato-bean-bell-pepper-soup-in-black-bowl.jpg?s=612x612&w=is&k=20&c=JE0W93a7lyMnpCPlJu8UxgkllA_Zpv_jkAdlsapY4w8=",
                    restaurantId = 14
                )
            )
            //restaurant 15
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Spicy Szechuan Tofu Stir Fry",
                    foodPrice = 12.99,
                    foodCategory = "Asian Vegan Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1293564637/photo/mapo-tofu-stir-fried-tofu-with-hot-spicy-sauce-in-white-plate.jpg?s=612x612&w=is&k=20&c=KnbUr7lMIgI73X9gMGcwZfUMQm7hA013m8Ct9XqMWBY=",
                    restaurantId = 15
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Miso Glazed Eggplant Donburi",
                    foodPrice = 10.99,
                    foodCategory = "Asian Vegan Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1282087877/photo/korean-spicy-eggplant-with-spicy-sauce-and-sesame-seeds-in-a-bowl-of-rice-and-chopsticks-on-a.jpg?s=612x612&w=is&k=20&c=ilpRFzC11ZN8uH-2_S8Zhrqe7FP8GOn82aL1_jSeEps=",
                    restaurantId = 15
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Thai Green Curry with Tofu",
                    foodPrice = 13.99,
                    foodCategory = "Asian Vegan Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1218215429/photo/vegetarian-thai-green-curry-with-tofu-in-black-bowl-at-dark-slate-background-veg-green-thai.jpg?s=612x612&w=is&k=20&c=bevb9prW0GxXwzJorQWTyosfs-GQKBJhD_ywS66_qNE=",
                    restaurantId = 15
                )
            )
            //restaurant 16
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Buddah Bowl Bliss",
                    foodPrice = 12.99,
                    foodCategory = "Asian Vegan Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1133157208/photo/healthy-vegan-championship-game-and-green-smoothie-on-dark-background.jpg?s=612x612&w=is&k=20&c=F9YnoYSkXKYtswDCN2VGXQF7hJyloLWxN_IMpjEHvWI=",
                    restaurantId = 16
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Tomato Linguini Pasta",
                    foodPrice = 14.99,
                    foodCategory = "Asian Vegan Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1407715348/photo/classic-linguini-pasta-with-tomatoes-on-a-light-gray-background.jpg?s=612x612&w=is&k=20&c=H5nU-DxoYLwOHueih07zCMsM5ubwEpDw6ti_iJ_FKPQ=",
                    restaurantId = 16
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Chickpea Salad",
                    foodPrice = 10.99,
                    foodCategory = "Asian Vegan Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1213546819/photo/chickpea-salad-on-a-gray-background-top-view.jpg?s=612x612&w=is&k=20&c=oJ2nkM-eVnSjsF-fbTmXZF1jJzZRg39tTGAQq9Q0_lo=",
                    restaurantId = 16
                )
            )
            //restaurant 17
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Lentil Dahl",
                    foodPrice = 8.99,
                    foodCategory = "Indian Vegan Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1130228942/photo/indian-dal-traditional-indian-soup-lentils-indian-dhal-spicy-curry-in-bowl-spices-herbs.jpg?s=612x612&w=is&k=20&c=7qRkgEuKjIDYV5j5sXZuAYrEN3_LTWbg4rdYUPJq5Ok=",
                    restaurantId = 17
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Vegetable Biryan",
                    foodPrice = 10.99,
                    foodCategory = "Indian Vegan Cuisine",
                    foodImage = "https://media.istockphoto.com/id/179085494/photo/indian-biryani.jpg?s=612x612&w=is&k=20&c=-UCt4UXLBXH-6FswBUyW1CAJRb5KyKperUB69Aic6U0=",
                    restaurantId = 17
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Tofu Tikka Masala",
                    foodPrice = 9.99,
                    foodCategory = "Indian Vegan Cuisine",
                    foodImage = "https://media.istockphoto.com/id/486066908/photo/indian-style-cottage-cheese-vegetarian-curry-dish-kadai-paneer.jpg?s=612x612&w=is&k=20&c=fbxfWlvZZKzCqvLiP5Uu_Tv_6Yz29Wh0dKJOw-YQbyg=",
                    restaurantId = 17
                )
            )
            //restaurant 18
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Palak Paneer",
                    foodPrice = 8.99,
                    foodCategory = "Indian Vegan Cuisine",
                    foodImage = "https://media.istockphoto.com/id/851889508/photo/palak-paneer.jpg?s=612x612&w=is&k=20&c=P4mM2ECDfprVS-YR6ZoshK5aWdTnH6kfx6r9ASyzwmo=",
                    restaurantId = 18
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Chickpea Curry",
                    foodPrice = 6.99,
                    foodCategory = "Indian Vegan Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1338173789/photo/image-blue-plates-homemade-punjabi-chole-meal-white-rice-lachha-paratha-spoon-fork-striped.jpg?s=612x612&w=is&k=20&c=YmxNL9BdYlOInrWfXyjoCH1xv4IW9j6MQ9CPi3s5Nng=",
                    restaurantId = 18
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Aloo Gobi",
                    foodPrice = 7.99,
                    foodCategory = "Indian Vegan Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1317737079/photo/curry-roasted-cauliflower-vegetarian-vegetable-dish-selective-focus-copy-space.jpg?s=612x612&w=is&k=20&c=6k1KzTsA-abSc9Mf_FGXTnQdVGPrOUyKYjdGyYwawM4=",
                    restaurantId = 18
                )
            )
        }
    }

    private fun addVeganFood(capstoneViewModel: CapstoneViewModel) {
        capstoneViewModel.viewModelScope.launch {
            //restaurant 19
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Tofu Teriyaki Bowl",
                    foodPrice = 10.99,
                    foodCategory = "East Asian Vegetarian Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1176497385/photo/teriyaki-tofu-salad-with-kale-and-chickpeas-in-a-wooden-bowl-copy-space-top-view.jpg?s=612x612&w=is&k=20&c=e94xgxEJRhdy4WlZsYRAc42mw3IqXeQMsmxZEiz1s3c=",
                    restaurantId = 19
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Sesame Ginger Noodles",
                    foodPrice = 9.99,
                    foodCategory = "East Asian Vegetarian Cuisine",
                    foodImage = "https://media.istockphoto.com/id/628471696/photo/soba-noodle-ginger-garlic-soy-sauce.jpg?s=612x612&w=is&k=20&c=xQgEoUZbO9UzuOflsDAcMU6aMtjITCMYcq38jRnFL4I=",
                    restaurantId = 19
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Vegetable Hot Pot",
                    foodPrice = 13.99,
                    foodCategory = "East Asian Vegetarian Cuisine",
                    foodImage = "https://media.istockphoto.com/id/689905218/photo/japanese-hot-pot-chanko-nabe.jpg?s=612x612&w=is&k=20&c=MgMHdYhecD7SHIC7kWkqy-wyA3R5Xes84PbGVMnh-k4=",
                    restaurantId = 19
                )
            )

            //restaurant 20
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Vegetarian Bibimbap ",
                    foodPrice = 11.49,
                    foodCategory = "East Asian Vegetarian Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1177113079/photo/grilled-tofu-buddha-bowl.jpg?s=612x612&w=is&k=20&c=sPEn6kEb1cD78k27RVUjDJa0HXSD9l2wa1_KY1EQWeU=",
                    restaurantId = 20
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Vegetarian Stir-Fried Udon Noodles",
                    foodPrice = 10.99,
                    foodCategory = "East Asian Vegetarian Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1135287343/photo/udon-stir-fry-noodles-with-vegetables-in-wok-pan.jpg?s=612x612&w=is&k=20&c=Mx3T5npXGITN3W3v58QOJkvsoXXpsR4yztGcdVFEzBs=",
                    restaurantId = 20
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Kimchi Fried Rice",
                    foodPrice = 7.99,
                    foodCategory = "East Asian Vegetarian Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1255727377/photo/kimchi-fried-rice-with-fried-egg-and-nori.jpg?s=612x612&w=is&k=20&c=uq7MeGcUxYeS-wIDwNNIo--O6Y-W7DhXsqq5082JIw0=",
                    restaurantId = 20
                )
            )

            //restaurant 21
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Zen Bowl",
                    foodPrice = 12.99,
                    foodCategory = "Vegetarian Fusion Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1293479617/photo/woman-hands-eating-vegan-salad-of-baked-vegetables-avocado-tofu-and-buckwheat-buddha-bowl-top.jpg?s=612x612&w=is&k=20&c=O_V2oJmE4AOJcBix3y3EmJhJhMevoCGVIl_WpWR5XDk=",
                    restaurantId = 21
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Sesame Seitan Stir-fry",
                    foodPrice = 13.99,
                    foodCategory = "Vegetarian Fusion Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1783213599/photo/stir-fried-tempeh-and-long-beans.jpg?s=612x612&w=is&k=20&c=f2BRyKV-_o9MVRh0XWL0e2M0W3Jrg1uYHDprUEFjV5g=",
                    restaurantId = 21
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Zen Garden Pizza",
                    foodPrice = 14.99,
                    foodCategory = "Vegetarian Fusion Cuisine",
                    foodImage = "https://media.istockphoto.com/id/842082336/photo/homemade-veggie-pizza-with-mushrooms-peppers.jpg?s=612x612&w=is&k=20&c=_au8qOMosP9q4PrUQmtHFqHHNGyMMJUNVs4044eoF_0=",
                    restaurantId = 21
                )
            )
            //restaurant 22
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Mexican Tacos ",
                    foodPrice = 11.99,
                    foodCategory = "Vegetarian Fusion Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1253305040/photo/mexican-traditional-authentic-homemade-tacos-with-pulled-pork-beef-chili-con-carne-serve-with.jpg?s=612x612&w=is&k=20&c=1M5gyymkRg5fFUgKdvo5a8ebawniekJX3sjch2QHFdQ=",
                    restaurantId = 22
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Saffron Infused Risotto",
                    foodPrice = 15.99,
                    foodCategory = "Vegetarian Fusion Cuisine",
                    foodImage = "https://media.istockphoto.com/id/494182241/photo/risotto.jpg?s=612x612&w=is&k=20&c=YV34JS_HtJ3t6sD9S87XfKQgdopfXZNV4ZqoaL73zhw=",
                    restaurantId = 22
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Quinoa Stuffed Bell Peppers ",
                    foodPrice = 11.99,
                    foodCategory = "Vegetarian Fusion Cuisine",
                    foodImage = "https://media.istockphoto.com/id/641769648/photo/raw-quinoa-stuffed-sweet-peppers-in-a-cast-iron-skillet-top-view-healthy-vegetarian-food.jpg?s=612x612&w=is&k=20&c=3VLI3TmkFFnN-7lGsDIY3CEBnAR7Nq55Gps091Ij_E8=",
                    restaurantId = 22
                )
            )

            //restaurant 23
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Butternut Squash Ravioli ",
                    foodPrice = 12.99,
                    foodCategory = "Western Vegetarian Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1356661908/photo/homemade-butternut-squash-ravioli.jpg?s=612x612&w=is&k=20&c=TxM0A_GVAm05mnIFwtIPpSiy7yPf2uD1eyHgUHgHSpE=",
                    restaurantId = 23
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Roasted Beetroot and Goat Cheese Salad ",
                    foodPrice = 9.99,
                    foodCategory = "Western Vegetarian Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1194291229/photo/vegetarian-salad-sheep-cheese-baked-roasted-vegetables-keto-ketogenic-dash-diet-mix-of.jpg?s=612x612&w=is&k=20&c=XvgQpceIwqSZK5BmkPl6sIvltG7B8sCyeP9wC07-ft8=",
                    restaurantId = 23
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Vegetarian Cowboy Chilli",
                    foodPrice = 9.99,
                    foodCategory = "Western Vegetarian Cuisine",
                    foodImage = "https://media.istockphoto.com/id/519891447/photo/spicy-cowboy-beans-with-hassleback-potatoe-with-herbs.jpg?s=612x612&w=is&k=20&c=NMDmyqWi_6JHKg5SdqypcQ6Ffz3NO_7wq69QXzeIfEk=",
                    restaurantId = 23
                )
            )

            //restaurant 24
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Spinach and Ricotta Ravioli",
                    foodPrice = 13.99,
                    foodCategory = "Western Vegetarian Cuisine",
                    foodImage = "https://media.istockphoto.com/id/506895136/photo/ravioli-with-spinach-and-ricotta-cheese-parmesan-in-a-plate.jpg?s=612x612&w=is&k=20&c=tdzlmTTArWzEpjj6rfVC1lshnflSXEEBQgTti7OrQYQ=",
                    restaurantId = 24
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Mediterranean Veggie Wrap",
                    foodPrice = 10.99,
                    foodCategory = "Western Vegetarian Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1420910368/photo/wraps-with-a-soft-flatbread-rolled-around-a-filling-with-vegetables-and-cheese-tomato-fried.jpg?s=612x612&w=is&k=20&c=0xor2bAd0haFJWkbBWsr_kTGRV9_jrH7UbvA1_3lgmA=",
                    restaurantId = 24
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Roasted Butternut Squash Soup",
                    foodPrice = 8.99,
                    foodCategory = "Western Vegetarian Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1276910170/photo/pumpkin-and-carrot-soup-with-cream-in-black-bowl-dark-background-top-view.jpg?s=612x612&w=is&k=20&c=MiWiA-ZC1Q36bILgeMEITaobjQBtfhV8i5QykQ6OzPs=",
                    restaurantId = 24
                )
            )
        }
    }

    private fun addNonHalalFood(capstoneViewModel: CapstoneViewModel) {
        capstoneViewModel.viewModelScope.launch {
            //restaurant 7
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Fiery Szechuan Beef",
                    foodPrice = 14.99,
                    foodCategory = "Chinese Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1193264018/photo/szechwan-dish-shuizhu-beef-served-at-lunchtime-in-yokohama.jpg?s=612x612&w=is&k=20&c=AtB5jSl8lXANguIb5kWGfd9k8su_uYJJ-cgsuaRwy80=",
                    restaurantId = 7
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Crispy Pork Belly with Chili Garlic Sauce",
                    foodPrice = 12.99,
                    foodCategory = "Chinese Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1449825872/photo/fried-crispy-pork-with-jasmine-rice-in-the-food-containner.jpg?s=612x612&w=is&k=20&c=Ds7L2vLgoBaqzT2T-bDF7e_pLtp-_FEbJ5i2fKtTDLY=",
                    restaurantId = 7
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Salt and Pepper Squid",
                    foodPrice = 10.99 ,
                    foodCategory = "Chinese Cuisine",
                    foodImage = "https://media.istockphoto.com/id/157103558/photo/salt-and-pepper-squid.jpg?s=612x612&w=is&k=20&c=LsuULz3C8tyAEZlKhoSYguRkQ6suEvK_S8AX1uwsAog=",
                    restaurantId = 7
                )
            )

            //restaurant 8
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Peking Duck with Hoisin Sauce",
                    foodPrice = 18.99,
                    foodCategory = "Chinese Cuisine",
                    foodImage = "https://media.istockphoto.com/id/584211460/photo/crispy-peking-duck-wraps.jpg?s=612x612&w=is&k=20&c=cOK-FwYzo6Y4NnQkkgH7bKHN7YAUmtgZhG45nDAO79E=",
                    restaurantId = 8
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Spicy Kung Pao Chicken",
                    foodPrice = 13.99,
                    foodCategory = "Chinese Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1176607728/photo/schezwan-chicken-or-dragon-chicken-in-black-bowl-at-dark-slate-background-szechuan-chicken-is.jpg?s=612x612&w=is&k=20&c=egABAbT_-LY6xuT4C0bpqFrJf2uW0elISTHuqmfZJwA=",
                    restaurantId = 8
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Braised Pork Spare Ribs",
                    foodPrice = 15.99,
                    foodCategory = "Chinese Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1401959852/photo/homemade-spicy-asian-baby-back-ribs.jpg?s=612x612&w=is&k=20&c=Z8nn0ALiYrq4KmCkkT0tBXL9rIJlCHqSjt3x6o8fGgM=",
                    restaurantId = 8
                )
            )
            //restaurant 9
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Spicy Pork Bulgogi",
                    foodPrice = 15.99,
                    foodCategory = "Korean Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1327254229/photo/stir-fried-pork-kimchi.jpg?s=612x612&w=is&k=20&c=3LHYQe3Hz0032MV4euhvtFC3Bz2CFy_7MbH5l3Pj7f8=",
                    restaurantId = 9
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Kimchi Jjigae",
                    foodPrice = 12.99,
                    foodCategory = "Korean Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1309116531/photo/korean-army-base-stew.jpg?s=612x612&w=is&k=20&c=mfzF6wSVJ66HOzG0a4MHyrxD1li-rLRDYd2LOJD6OyM=",
                    restaurantId = 9
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Seafood Pancake",
                    foodPrice = 14.99,
                    foodCategory = "Korean Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1289388785/photo/shrimp-and-garlic-chive-korean-pancake.jpg?s=612x612&w=is&k=20&c=VFIK_qIpWhEFURRYB1Q4iSVSzLx0qY6c-LuYTsSveBc=",
                    restaurantId = 9
                )
            )
            //restaurant 10
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Dakgalbi (Spicy Stir-Fried Chicken) ",
                    foodPrice = 16.99,
                    foodCategory = "Korean Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1439939007/photo/dakgalbi-or-dak-galbi-is-korean-spicy-chicken-stir-fry.jpg?s=612x612&w=is&k=20&c=62HG8aTALaUJELqSBl22IuxkDh3AM2VcqKRH0MVSZTc=",
                    restaurantId = 10
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Japchae (Stir-Fried Glass Noodle",
                    foodPrice = 13.99,
                    foodCategory = "Korean Cuisine",
                    foodImage = "https://media.istockphoto.com/id/534832769/photo/stir-fried-glass-noodles-and-vegetables.jpg?s=612x612&w=is&k=20&c=D5PidSa8FiCVX1qQHybPiFfQKiOa8QZHcLIA3LxHh_o=",
                    restaurantId = 10
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Bibimbap",
                    foodPrice = 11.99,
                    foodCategory = "Korean Cuisine",
                    foodImage = "https://media.istockphoto.com/id/493066234/photo/korean-bibimbap-dish.jpg?s=612x612&w=is&k=20&c=6l_mgazd-PVGz_Hf6HNWlwePUiZ24ctt9vbHWet6wXE=",
                    restaurantId = 10
                )
            )
            //restaurant 11
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Spicy Basil Beef",
                    foodPrice = 12.99,
                    foodCategory = "Thai Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1335248053/photo/top-view-of-basil-rice-with-pork-or-beef-topping-fried-egg-thai-food.jpg?s=612x612&w=is&k=20&c=Y2djkpQ-86_y63fKWz3HaxddIS5P8Olh0lz1gsndHEk=",
                    restaurantId = 11
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Tom Yum Goong Soup",
                    foodPrice = 9.99,
                    foodCategory = "Thai Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1172903419/photo/thailands-famous-rich-red-coconut-milk-based-delicious-tom-yam-kung-soup-in-a-bowl-on-an.jpg?s=612x612&w=is&k=20&c=UdLl2i8MGFcpQWguwMTz55fChp2vOBSRH-w97utbd3Y=",
                    restaurantId = 11
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Crispy Garlic Pork",
                    foodPrice = 11.99,
                    foodCategory = "Thai Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1284510765/photo/fried-pork-with-garlic-and-sticky-rice-on-plate-thai-food.jpg?s=612x612&w=is&k=20&c=xDy0wUqg-tjCOPQbjCMUB8MRNNSBpUaG4SqmJXqYqdE=",
                    restaurantId = 11
                )
            )
            //restaurant 12
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Thai Chili Chicken",
                    foodPrice = 10.99,
                    foodCategory = "Thai Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1450841111/photo/thai-chinese-food-chicken-with-cashew-nuts-or-gai-pad-med-mamuang.jpg?s=612x612&w=is&k=20&c=CKDWEDoEjIBKcDypa5y-l3K8w2JkmjtyR2in8gVvdtc=",
                    restaurantId = 12
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Pad Thai Noodles",
                    foodPrice = 13.99,
                    foodCategory = "Thai Cuisine",
                    foodImage = "https://media.istockphoto.com/id/596799642/photo/beef-pad-thai-shot-from-overhead-view.jpg?s=612x612&w=is&k=20&c=2yDobTQcGhen_OpYOxoWPwrF7VvLd8cp719zFnCqqr4=",
                    restaurantId = 12
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Coconut Milk Curry Shrimp",
                    foodPrice = 14.99,
                    foodCategory = "Thai Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1367359911/photo/thai-shrimps-red-curry-thailand-tradition-red-curry-soup-with-shrimps-prawns-and-coconut-milk.jpg?s=612x612&w=is&k=20&c=1koxm4CgfC2QOOHkQ_Fe_WY_BGQwDqgEI1ti6T6ZqTY=",
                    restaurantId = 12
                )
            )
        }
    }

    private fun addHalalFood(capstoneViewModel: CapstoneViewModel) {
        capstoneViewModel.viewModelScope.launch {
            //restaurant 1
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Nasi Goreng Bunga Raya",
                    foodPrice = 12.99,
                    foodCategory = "Malaysian Cuisine",
                    foodImage = "https://media.istockphoto.com/id/526149515/photo/nasi-lemak-malaysian-cuisine.jpg?s=1024x1024&w=is&k=20&c=X3PeiA2SK_qAxpoq3L6d_Ktyiwx8NMHctkm98svTyL0=",
                    restaurantId = 1
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Ayam Percik Delight",
                    foodPrice = 14.99,
                    foodCategory = "Malaysian Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1342290072/photo/malaysian-ayam-percik-or-roasted-spiced-chicken-is-a-grilled-chicken-dish-that-is-cooked-with.jpg?s=2048x2048&w=is&k=20&c=OuWc5HofsPgvWhcN3MSU6I6cJyq6E1hf_IZYIQtwfBM=",
                    restaurantId = 1
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Seafood Laksa Supreme",
                    foodPrice = 16.99,
                    foodCategory = "Malaysian Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1035322500/photo/coconut-shrimp-laksa-soup-on-a-dark-background-top-view-copy-space.jpg?s=2048x2048&w=is&k=20&c=qrKbhDcAPzsb_fHlhggTZrK0cJMUZUV6Wa8YAScxcvQ=",
                    restaurantId = 1
                )
            )
            //restaurant 2
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Nasi Goreng Kampung",
                    foodPrice = 12.99,
                    foodCategory = "Malaysian Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1466561162/photo/village-fried-rice-or-nasi-goreng-kampung-made-with-lots-of-toppings-tomato-fried-egg-crisp.jpg?s=612x612&w=is&k=20&c=pGSCLiNVqpev9cKxHgQa_6-SfPhF8fJiOJZnp3WZjJ0=",
                    restaurantId = 2
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Ayam Masak Merah",
                    foodPrice = 14.99,
                    foodCategory = "Malaysian Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1281369179/photo/tom-kha-gai-coconut-milk-soup-with-chicken-thai-traditional-food-with-ingredients.jpg?s=612x612&w=is&k=20&c=ES0GY8r9HZFOU-GyRSaKjyAPP7fydflioOBzjMBDpow=",
                    restaurantId = 2
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Sambal Udang Petai",
                    foodPrice = 16.99,
                    foodCategory = "Malaysian Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1399678191/photo/chili-prawns.jpg?s=612x612&w=is&k=20&c=kHLzShqTHuB0IERIWgUDAagPMgjU_l9jUAqI_8ILAjg=",
                    restaurantId = 2
                )
            )

            //restaurant 3
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Sakura Rainbow Roll ",
                    foodPrice = 12.99,
                    foodCategory = "Japanese Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1316208852/photo/a-stack-of-beautiful-sushi-on-a-wooden-texture-table-delicious-food.jpg?s=612x612&w=is&k=20&c=jBKv-4gJvmQHp1pt6dZbUuNvNd3DI4Lh5KxGtovSHmM=",
                    restaurantId = 3
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Halal Tempura Crunch Roll",
                    foodPrice = 10.99,
                    foodCategory = "Japanese Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1143627722/photo/crunchy-roll-rice-roll-of-prawn-tempura-with-spicy-miso-sauce-japanese-food.jpg?s=612x612&w=is&k=20&c=SpX3J_7kMWI1RSFpgwRA83oc94PIWRNpo7xkqOLq_zM=",
                    restaurantId = 3
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Teriyaki Chicken Bento Box",
                    foodPrice = 14.99,
                    foodCategory = "Japanese Cuisine",
                    foodImage = "https://media.istockphoto.com/id/154311143/photo/japanese-cuisine-chicken-teriyaki%E3%80%80bento.jpg?s=612x612&w=is&k=20&c=kj4khiZaSUUeS_3971YPvjYM4k4F_oakdK4XgE1Rn5o=",
                    restaurantId = 3
                )
            )

            //restaurant 4
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Zen Ramen Delight",
                    foodPrice = 12.99,
                    foodCategory = "Japanese Cuisine",
                    foodImage = "https://media.istockphoto.com/id/627218822/photo/instant-noodle.jpg?s=612x612&w=is&k=20&c=ZU_cbOt9pk80S8FgYyGKyGasZMLz2TAJWPE870oNOlA=",
                    restaurantId = 4
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Teppanyaki Teriyaki Chicken",
                    foodPrice = 15.99,
                    foodCategory = "Japanese Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1410669727/photo/chicken-teriyaki-served-in-a-dish-isolated-on-wooden-background-side-view-of-teppanyaki.jpg?s=612x612&w=is&k=20&c=IwUB_xDz12VYC9ztyM86IFVlFsMCHWTmOvP9uz1AaGE=",
                    restaurantId = 4
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Sizzling Seafood Udon",
                    foodPrice = 18.99,
                    foodCategory = "Japanese Cuisine",
                    foodImage = "https://media.istockphoto.com/id/484385880/photo/seafood-udon.jpg?s=612x612&w=is&k=20&c=_YuEPa_bk8S552gbGLaDNQvoLzvhUTm1pr-5NN_oaz0=",
                    restaurantId = 4
                )
            )

            //restaurant 5
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Sultan's Delight",
                    foodPrice = 15.99,
                    foodCategory = "Western Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1986028746/photo/hunkar-begendi-made-with-eggplant-and-meat-served-in-glasgow-scotland-england-uk.jpg?s=612x612&w=is&k=20&c=pBzcgu6E5rrV9c2DbQ7cuU8KsHnW7Fo0rxXqGbSLG_w=",
                    restaurantId = 5
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Arabian Night's Lamb Shank",
                    foodPrice = 18.99,
                    foodCategory = "Western Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1452629339/photo/spice-marinated-grilled-lamb-chops-or-rack-with-baby-potatoes-and-roast-gravy.jpg?s=612x612&w=is&k=20&c=3Abx1O9koe3LrMPE0o9qGc1AZvO4i22HYzLDEYnN6bs=",
                    restaurantId = 5
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Casablanca Seafood Linguine",
                    foodPrice = 20.99,
                    foodCategory = "Western Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1129614168/photo/traditional-italian-seafood-pasta-with-clams-spaghetti-alle-vongole-in-the-pan.jpg?s=612x612&w=is&k=20&c=KeIwrPDrwG5P_U-zpObzkETe71eXinEuaxCvl0q_3iE=",
                    restaurantId = 5
                )
            )

            //restaurant 6
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Arabian Spice Ribeye",
                    foodPrice = 24.99,
                    foodCategory = "Western Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1422307046/photo/spicy-lamb-chops-with-salad-mayo-dip-chili-sauce-and-fries-isolated-on-cutting-board-side.jpg?s=612x612&w=is&k=20&c=PTAEA0PF9VZE8m6tgcTbz8yydexOEgSt-HzTPiq35K0=",
                    restaurantId = 6
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Mediterranean Lamb Burger",
                    foodPrice = 16.99,
                    foodCategory = "Western Cuisine",
                    foodImage = "https://media.istockphoto.com/id/637790866/photo/100-lamb-greek-burger.jpg?s=612x612&w=is&k=20&c=AXS2UXyTCDO1v5jDnl5rW1T2CiBRx3C7-_il1SoX79s=",
                    restaurantId = 6
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Shawarma Platter (Chicken)",
                    foodPrice = 18.99,
                    foodCategory = "Western Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1327266181/photo/shawarma-beef-plate-solated-on-white-background-n.jpg?s=612x612&w=is&k=20&c=f8egJZoxxe17WGTCY6Jigakjijb2qzKuHbIU7uBXDVY=",
                    restaurantId = 6
                )
            )
            capstoneViewModel.insertFood(
                Food(
                    foodName = "Shawarma Platter (Beef)",
                    foodPrice = 20.99,
                    foodCategory = "Western Cuisine",
                    foodImage = "https://media.istockphoto.com/id/1327266181/photo/shawarma-beef-plate-solated-on-white-background-n.jpg?s=612x612&w=is&k=20&c=f8egJZoxxe17WGTCY6Jigakjijb2qzKuHbIU7uBXDVY=",
                    restaurantId = 6
                )
            )
        }
    }
}
