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
                            capstoneViewModel.insertRestaurant(Restaurant("Zaynab's Kitchen", "Halal"))
                            capstoneViewModel.insertRestaurant(Restaurant("Saffron Oasis", "Halal"))
                            capstoneViewModel.insertRestaurant(Restaurant("Majestic Halal Haven", "Halal"))

                            //Non-halal
                            capstoneViewModel.insertRestaurant(Restaurant("Burger Bonanza Grill", "Non-Halal"))
                            capstoneViewModel.insertRestaurant(Restaurant("Smokehouse sensation", "Non-Halal"))
                            capstoneViewModel.insertRestaurant(Restaurant("Carnivore's Cove", "Non-Halal"))

                            //Vegan/Vegetarian
                            capstoneViewModel.insertRestaurant(Restaurant("Greenleaf Haven", "Vegan/Vegetarian"))
                            capstoneViewModel.insertRestaurant(Restaurant("Plantastic Plates", "Vegan/Vegetarian"))
                            capstoneViewModel.insertRestaurant(Restaurant("Harvest Bistro", "Vegan/Vegetarian"))
                            // capstoneViewModel.deleteRestaurant(15)
                        }
                    },
                ) {
                    Text("Add Restaurant")
                }

                Button(
                    onClick = {
                        capstoneViewModel.viewModelScope.launch {
                            //res 3
                            capstoneViewModel.insertFood(
                                Food(
                                foodName = "Majestic Lamb Shank Delight",
                            foodPrice = 18.99,
                            foodCategory = "Meat",
                            foodImage = "https://www.foodadvisor.my/attachments/608caba03897c407d84c983da9ee6f62327ab0e3/store/fill/1000/500/72f3b70d74a6ea0615b590652496922d69f1ba878118650aade019d1ad44/featured_image.jpg",
                            restaurantId = 3)
                            )

                            capstoneViewModel.insertFood(
                                Food(
                                foodName = "Sultan's Chicken Kebab Platter",
                                foodPrice = 14.50,
                                foodCategory = "Meat",
                            foodImage = "https://boons-marketplace-restaurant-web-images.s3.us-east-2.amazonaws.com/uploads/menu/IgYT7WrVKcy1EG5DuAQl.jpg",
                            restaurantId = 3)
                            )

                            capstoneViewModel.insertFood(
                                Food(
                                foodName = "Royal Saffron Rice Feast",
                            foodPrice = 12.99,
                            foodCategory = "Rice",
                            foodImage = "https://www.whiskaffair.com/wp-content/uploads/2019/05/Saffron-Rice-2-3.jpg",
                            restaurantId = 3)
                            )

                            capstoneViewModel.insertFood(
                                Food(
                                foodName = "Majestic Biryani Supreme",
                                foodPrice = 11.50,
                                foodCategory = "Rice",
                            foodImage = "https://miro.medium.com/v2/resize:fit:450/1*m1_trJ_qbjkrTxl_yaLaCg.jpeg",
                            restaurantId = 3)
                            )

                            capstoneViewModel.insertFood(
                                Food(
                                foodName = "Rose Petal Panna Cotta",
                            foodPrice = 6.50,
                            foodCategory = "Dessert",
                            foodImage = "https://jajabakes.com/wp-content/uploads/2019/08/rose-panna-cotta-4.jpg",
                            restaurantId = 3)
                            )

                            capstoneViewModel.insertFood(
                                Food(
                                foodName = "Date and Nut Baklava",
                            foodPrice = 5.50,
                            foodCategory = "Dessert",
                            foodImage = "https://www.californiagreekgirl.com/wp-content/uploads/2011/02/Chocolate-Baklava-1.jpg",
                            restaurantId = 3)
                            )

                            capstoneViewModel.insertFood(
                                Food(
                                foodName = "Majestic Spicy Ramen Bowl",
                            foodPrice = 14.99,
                            foodCategory = "Noodles",
                            foodImage = "https://media1.dallasobserver.com/dal/imager/u/original/18045459/wolfgang_ten_ramen_tonkotsu__1_.jpg",
                            restaurantId = 3)
                            )

                            capstoneViewModel.insertFood(
                                Food(
                                foodName = "Heavenly Vegetable Chow Mein",
                            foodPrice = 10.50,
                            foodCategory = "Noodles",
                            foodImage = "https://cupfulofkale.com/wp-content/uploads/2020/02/Vegan-Vegetable-Chow-Mein.jpg.webp",
                            restaurantId = 3)
                            )

                            capstoneViewModel.insertFood(
                                Food(
                                foodName = "Majestic Seafood Platter",
                                foodPrice = 17.99,
                                foodCategory = "Seafood",
                            foodImage = "https://img.taste.com.au/9-tT5J3N/taste/2016/11/grilled-seafood-platter-81225-1.jpeg",
                            restaurantId = 3)
                            )

                            capstoneViewModel.insertFood(
                                Food(
                                foodName = "Spiced Seafood Linguine",
                                foodPrice = 15.50,
                                foodCategory = "Seafood",
                            foodImage = "https://i0.wp.com/spicepaw.com/wp-content/uploads/2018/05/Spicy-Seafood-Linguine-9.jpg",
                            restaurantId = 3)
                            )

                            capstoneViewModel.insertFood(
                                Food(
                                foodName = "Majestic Falafel Roll",
                                foodPrice = 9.99,
                                foodCategory = "Fast food",
                            foodImage = "https://joyful-kitchen.com/wp-content/uploads/2022/04/royal-falafel-scaled.jpg",
                            restaurantId = 3)
                            )

                            capstoneViewModel.insertFood(
                                Food(
                                foodName = "Gourmet Veggie Wrap",
                                foodPrice = 8.50,
                                foodCategory = "Fast food",
                            foodImage = "https://www.foodiecrush.com/wp-content/uploads/2015/05/Hummus-Veggie-Wrap-foodiecrush.com-10.jpg",
                            restaurantId = 3)
                            )
                            
                            //
                            capstoneViewModel.insertFood(Food(
                                foodName = "Smoky BBQ Ribs",
                                foodPrice = 15.99,
                                foodCategory = "Meat",
                            foodImage = "https://res.cloudinary.com/fatty-butts-bbq/images/f_auto,q_auto/v1647644304/fattybuttsbbq/Smoked-Ribs/Smoked-Ribs.jpg?_i=AA",
                            restaurantId = 4))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Peppered Beef Tenderloin",
                                foodPrice = 18.49,
                                foodCategory = "Meat",
                            foodImage = "https://whatsgabycooking.com/wp-content/uploads/2019/12/WGC-Tenderloin-3-copy.jpg",
                            restaurantId = 4))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Sizzling Beef Rice Bowl",
                            foodPrice = 12.99,
                            foodCategory = "Rice",
                            foodImage = "https://storage.googleapis.com/leye_bucket/wp-content/uploads/9ccccf9a-sizzling-rice-beef.jpg",
                            restaurantId = 4))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Cajun Chicken Rice Plate",
                            foodPrice = 10.99,
                            foodCategory = "Rice",
                            foodImage = "https://img.taste.com.au/Ssi-Eelu/taste/2018/02/mar-18_cajun-chicken-rice-bowl-3000x2000-135698-1.jpg",
                            restaurantId = 4))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Decadent Chocolate Lava Cake",
                            foodPrice = 8.99,
                            foodCategory = "Dessert",
                            foodImage = "https://www.acouplecooks.com/wp-content/uploads/2022/02/Lava-Cake-005s.jpg",
                            restaurantId = 4))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Caramelized Banana Split",
                                foodPrice = 9.49,
                                foodCategory = "Dessert",
                            foodImage = "https://food.fnr.sndimg.com/content/dam/images/food/fullset/2015/12/1/1/CCTIA201H_Caramelized-Banana-Split-Sundae_s4x3.jpg.rend.hgtvcom.616.462.suffix/1449078371216.jpeg",
                            restaurantId = 4))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Spicy Shrimp Linguine",
                                foodPrice = 14.49,
                                foodCategory = "Noodles",
                            foodImage = "https://nomnompaleo.com/wp-content/uploads/2022/01/1000-Spicy-Shrimp-aaDSC_7419.jpg",
                            restaurantId = 4))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Beefy Alfredo Fettuccine",
                                foodPrice = 13.99,
                                foodCategory = "Noodles",
                            foodImage = "https://krollskorner.com/wp-content/uploads/2023/02/steakalfredo_9-2959.jpg",
                            restaurantId = 4))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Grilled Lobster Tails",
                                foodPrice = 22.99,
                                foodCategory = "Seafood",
                            foodImage = "https://www.wholesomeyum.com/wp-content/uploads/2021/06/wholesomeyum-Grilled-Lobster-Tail-Recipe-28.jpg",
                            restaurantId = 4))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Sizzling Garlic Butter Prawns",
                                foodPrice = 17.99,
                                foodCategory = "Seafood",
                            foodImage = "https://www.marionskitchen.com/wp-content/uploads/2021/08/20201119_Garlic-Butter-Prawns-11-scaled-e1628864662428.jpg",
                            restaurantId = 4))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Crispy Chicken Tenders Basket",
                            foodPrice = 9.99,
                            foodCategory = "Fast food",
                            foodImage = "https://popmenucloud.com/cdn-cgi/image/width=1920,height=1920,format=auto,fit=scale-down/wlczfrmv/d6819997-6f9b-4f42-8e4d-1ee40402835a.jpg",
                            restaurantId = 4))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Double Bacon Cheeseburger Combo",
                            foodPrice = 12.49,
                            foodCategory = "Fast food",
                            foodImage = "https://wendys.com.ph/cdn/shop/files/baconcheeseburger_combo.png?v=1692065227",
                            restaurantId = 4))
                            
                            //res 5
                            capstoneViewModel.insertFood(Food(
                                foodName = "Smoked Brisket Platter",
                                foodPrice = 22.99,
                                foodCategory = "Meat",
                            foodImage = "https://www.gffoodservice.com.au/content/uploads/2015/09/img-ideas-banner_texas_platter_@2x.jpg",
                            restaurantId = 5))

                            capstoneViewModel.insertFood(Food(
                                foodName = "BBQ Pork Belly",
                                foodPrice = 16.50,
                                foodCategory = "Meat",
                            foodImage = "https://cookathomemom.com/wp-content/uploads/2022/10/Air-Fryer-Pork-Belly-Bites-2.jpg",
                            restaurantId = 5))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Cajun Chicken Rice Bowl",
                            foodPrice = 14.99,
                            foodCategory = "Rice",
                            foodImage = "https://images.squarespace-cdn.com/content/v1/5e4eabf35198d84399d289cf/1592413166190-I7J4XXSJDI5WAPBXHC82/Cajun+Chicken+%26+Rice+Bowl+Recipe",
                            restaurantId = 5))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Pulled Pork and Beans",
                            foodPrice = 12.50,
                            foodCategory = "Rice",
                            foodImage = "https://i.dailymail.co.uk/1s/2019/05/21/17/13771188-7054713-Delicious_This_popular_recipe_is_perfect_if_you_ve_got_a_large_g-a-58_1558455209802.jpg",
                            restaurantId = 5))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Smoked Chocolate Pecan Pie",
                            foodPrice = 9.50,
                            foodCategory = "Dessert",
                            foodImage = "https://www.smokedmeatsunday.com/wp-content/uploads/2022/10/Smoked-Chocolate-Pecan-Pie-17-scaled.jpg",
                            restaurantId = 5))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Bourbon-Infused Bread Pudding",
                            foodPrice = 8.99,
                            foodCategory = "Dessert",
                            foodImage = "https://www.foodandwine.com/thmb/1LWgxFn9txkrWD7RVz5jRvZjB9Q=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/HD-201301-r-bread-pudding-with-irish-whiskey-5f958dbef4b54c4d8021e0982ceef0c7.jpg",
                            restaurantId = 5))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Spicy BBQ Beef Noodles",
                            foodPrice = 15.99,
                            foodCategory = "Noodles",
                            foodImage = "https://taste.co.za/wp-content/uploads/2019/07/BBQ-charred-beef-with-spicy-noodles.jpg",
                            restaurantId = 5))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Smoked Chicken Alfredo",
                                foodPrice = 17.50,
                                foodCategory = "Noodles",
                            foodImage = "https://fashionablefoods.com/wp-content/uploads/2016/07/Featured-3.jpg",
                            restaurantId = 5))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Cedar Plank Grilled Salmon",
                            foodPrice = 18.99,
                            foodCategory = "Seafood",
                            foodImage = "https://assets.epicurious.com/photos/5b770caff1ff6a661bb16346/master/pass/Should-I-Be-Using-Grilling-Planks-2-16082018.jpg",
                            restaurantId = 5))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Smoked Paprika Shrimp Skewers",
                            foodPrice = 16.50,
                            foodCategory = "Seafood",
                            foodImage = "https://myuncommonsliceofsuburbia.com/wp-content/uploads/2020/06/grilled-shrimp-skewers-43-of-57-1-scaled.jpg",
                            restaurantId = 5))

                            capstoneViewModel.insertFood(Food(
                                foodName = "BBQ Bacon Cheeseburger",
                                foodPrice = 12.99,
                                foodCategory = "Fast food",
                            foodImage = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTaqgOARi20ztY03KtRdgrRnPc7AKd_MyrYhsBgsskQ16392MhH0ZWMiBDMmrABRpFYFOI&usqp=CAU",
                            restaurantId = 5))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Pulled Pork Sandwich",
                                foodPrice = 11.50,
                                foodCategory = "Fast food",
                            foodImage = "https://keviniscooking.com/wp-content/uploads/2023/04/Southern-Pulled-Pork-Sandwich-square.jpg",
                            restaurantId = 5))
                            
                            //res 6
                            capstoneViewModel.insertFood(Food(
                                foodName = "Prime Rib Steak",
                                foodPrice = 24.99,
                                foodCategory = "Meat",
                            foodImage = "https://food.fnr.sndimg.com/content/dam/images/food/fullset/2020/21/sliced-prime-rib-on-cutting-board.jpg.rend.hgtvcom.1280.960.suffix/1608568530146.jpeg",
                            restaurantId = 6))

                            capstoneViewModel.insertFood(Food(
                                foodName = "BBQ Pork Ribs",
                                foodPrice = 18.50,
                                foodCategory = "Meat",
                            foodImage = "https://static.toiimg.com/thumb/75428606.cms?imgsize=1815588&width=800&height=800",
                            restaurantId = 6))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Teriyaki Beef Bowl",
                                foodPrice = 15.99,
                                foodCategory = "Rice",
                            foodImage = "https://www.theseasonedmom.com/wp-content/uploads/2023/02/Beef-Teriyaki-Recipe-3.jpg",
                            restaurantId = 6))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Cajun Chicken and Rice",
                            foodPrice = 12.50,
                            foodCategory = "Rice",
                            foodImage = "https://img.hellofresh.com/f_auto,fl_lossy,q_auto,w_1200/hellofresh_s3/image/2019-w23-r4-blackened-chicken-and-cajun-rice-bowls-ad35dae8.jpg",
                            restaurantId = 6))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Molten Lava Chocolate Cake",
                            foodPrice = 8.50,
                            foodCategory = "Dessert",
                            foodImage = "https://www.melskitchencafe.com/wp-content/uploads/2023/01/updated-lava-cakes7.jpg",
                            restaurantId = 6))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Cheesecake Factory Sampler",
                                foodPrice = 7.99,
                                foodCategory = "Dessert",
                            foodImage = "https://cdn1.harryanddavid.com/wcsstore/HarryAndDavid/images/catalog/17_40034_30W_154e_v1xlx.jpg",
                            restaurantId = 6))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Beef Stir-Fry Noodles",
                                foodPrice = 14.99,
                                foodCategory = "Noodles",
                            foodImage = "https://casuallypeckish.com/wp-content/uploads/2021/11/Beef-noodle-stir-fry-1.jpg",
                            restaurantId = 6))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Shrimp Scampi Linguine",
                                foodPrice = 16.50,
                                foodCategory = "Noodles",
                            foodImage = "https://d14iv1hjmfkv57.cloudfront.net/assets/recipes/linguine-with-shrimp-scampi/_600x600_crop_center-center_61_line/Page-107-web-horizon.jpg",
                            restaurantId = 6))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Grilled Salmon Fillet",
                                foodPrice = 19.99,
                                foodCategory = "Seafood",
                            foodImage = "https://www.recipetineats.com/wp-content/uploads/2019/06/Marinated-Grilled-Salmon_8.jpg",
                            restaurantId = 6))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Lemon Garlic Butter Prawns",
                            foodPrice = 17.50,
                            foodCategory = "Seafood",
                            foodImage = "https://www.lecremedelacrumb.com/wp-content/uploads/2019/04/lemon-garlic-butter-shrimp-6-500x375.jpg",
                            restaurantId = 6))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Classic Cheeseburger",
                            foodPrice = 10.99,
                            foodCategory = "Fast food",
                            foodImage = "https://iambaker.net/wp-content/uploads/2019/05/cheeseburger-1.jpg",
                            restaurantId = 6))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Crispy Fried Chicken Sandwich",
                            foodPrice = 9.50,
                            foodCategory = "Fast food",
                            foodImage = "https://easychickenrecipes.com/wp-content/uploads/2019/06/featured-fried-chicken-sandwich-recipe-reshoot.jpg",
                            restaurantId = 6))

                            //res 7
                            capstoneViewModel.insertFood(Food(
                                foodName = "Coconut Curry Tofu Bowl",
                            foodPrice = 12.99,
                            foodCategory = "Rice",
                            foodImage = "https://www.yayforfood.com/wp-content/uploads/one-pan-tofu-coconut-curry4-scaled.jpg",
                            restaurantId = 7))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Mushroom & Spinach Risotto",
                            foodPrice = 11.49,
                            foodCategory = "Rice",
                            foodImage = "https://loveandgoodstuff.com/wp-content/uploads/2020/11/mushroom-spinach-risotto-1200x1200-1.jpg",
                            restaurantId = 7))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Lentil and Vegetable Soup",
                            foodPrice = 8.99,
                            foodCategory = "Soup",
                            foodImage = "https://simple-veganista.com/wp-content/uploads/2019/10/vegan-lentil-soup-recipe-5.jpg",
                            restaurantId = 7))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Tomato Basil Bisque",
                                foodPrice = 7.99,
                                foodCategory = "Soup",
                            foodImage = "https://reneenicoleskitchen.com/wp-content/uploads/2020/03/Creamy-Tomato-Basil-Bisque-Image-1a.jpg",
                            restaurantId = 7))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Quinoa Avocado Salad",
                                foodPrice = 10.49,
                                foodCategory = "Salad",
                            foodImage = "https://feelgoodfoodie.net/wp-content/uploads/2021/04/Avocado-Stuffed-Quinoa-Salad-14.jpg",
                            restaurantId = 7))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Greek Chickpea Salad",
                                foodPrice = 9.49,
                                foodCategory = "Salad",
                            foodImage = "https://www.aheadofthyme.com/wp-content/uploads/2021/04/chickpea-greek-salad-3.jpg",
                            restaurantId = 7))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Vegan Chocolate Mousse",
                                foodPrice = 6.99,
                                foodCategory = "Dessert",
                            foodImage = "https://www.connoisseurusveg.com/wp-content/uploads/2022/02/vegan-chocolate-mousse-square-2-of-2.jpg",
                            restaurantId = 7))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Fruit Sorbet Delight",
                                foodPrice = 5.99,
                                foodCategory = "Dessert",
                            foodImage = "https://img.freepik.com/premium-photo/sunkissed-fruit-sorbet-swirl-frosty-delight_961965-232.jpg",
                            restaurantId = 7))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Stir-Fried Veggie Udon Noodles",
                                foodPrice = 11.99,
                                foodCategory = "Noodles",
                            foodImage = "https://yejiskitchenstories.com/wp-content/uploads/2020/12/IMG_1934-2.jpg",
                            restaurantId = 7))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Zucchini Pasta Primavera",
                                foodPrice = 10.49,
                                foodCategory = "Noodles",
                            foodImage = "https://www.eatingwell.com/thmb/YhrjD1erQHzmsMyOH0O49Ey_Mrw=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/7574700-42b354bac8fc45288845b63c3d9f99a5.jpg",
                            restaurantId = 7))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Crispy Cauliflower Wings Basket",
                            foodPrice = 9.99,
                            foodCategory = "Fast food",
                            foodImage = "https://strengthandsunshine.com/wp-content/uploads/2022/02/Buffalo-Cauliflower-Wings-4.jpg",
                            restaurantId = 7))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Vegan Beyond Burger Combo",
                            foodPrice = 12.49,
                            foodCategory = "Fast food",
                            foodImage = "https://web.aw.ca/i/items/?i=beyond-meat-burger&d=beyond-meat-burger&cat=burgers&lang=beyond-meat-burger-en",
                            restaurantId = 7))

                            //res 8
                            capstoneViewModel.insertFood(Food(
                                foodName = "Spicy Chickpea and Vegetable Stir-Fry",
                            foodPrice = 12.99,
                            foodCategory = "Rice",
                            foodImage = "https://yupitsvegan.com/wp-content/uploads/2016/09/kung-pao-chickpeas-vegan-6.jpg",
                            restaurantId = 8))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Cilantro-Lime Quinoa Bowl",
                            foodPrice = 11.49,
                            foodCategory = "Rice",
                            foodImage = "https://www.twopeasandtheirpod.com/wp-content/uploads/2012/04/cilantro-lime-quinoa-500x427.jpg",
                            restaurantId = 8))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Creamy Butternut Squash Soup",
                            foodPrice = 8.99,
                            foodCategory = "Soup",
                            foodImage = "https://www.wholesomeyum.com/wp-content/uploads/2018/09/wholesomeyum-Roasted-Butternut-Squash-Soup-Instant-Pot-4.jpg",
                            restaurantId = 8))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Coconut Lentil Soup",
                                foodPrice = 8.49,
                                foodCategory = "Soup",
                            foodImage = "https://assets.bonappetit.com/photos/5a4e53204829cf767fcd9318/4:3/w_3748,h_2811,c_limit/vegan-coconut-lentil-soup.jpg",
                            restaurantId = 8))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Mango Avocado Kale Salad",
                            foodPrice = 10.99,
                            foodCategory = "Salad",
                            foodImage = "https://www.leftyspoon.com/wp-content/uploads/2015/05/massaged-kale-salad-avocado-mango-hazelnut-overhead.jpg",
                            restaurantId = 8))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Kale and Cranberry Superfood Salad",
                                foodPrice = 9.49,
                                foodCategory = "Salad",
                            foodImage = "https://www.foodfaithfitness.com/wp-content/uploads/2021/12/FG-TK-1-5.jpg",
                            restaurantId = 8))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Vegan Chocolate Avocado Mousse",
                            foodPrice = 6.99,
                            foodCategory = "Dessert",
                            foodImage = "https://www.onelovelylife.com/wp-content/uploads/2021/01/Avocado-Chocolate-Mousse18.jpg",
                            restaurantId = 8))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Coconut Mango Sorbet",
                                foodPrice = 5.99,
                                foodCategory = "Dessert",
                            foodImage = "https://images.eatsmarter.com/sites/default/files/styles/max_size/public/mango-and-coconut-sorbet-617570.jpg",
                            restaurantId = 8))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Sesame-Ginger Zucchini Noodle Stir-Fry",
                            foodPrice = 11.99,
                            foodCategory = "Noodles",
                            foodImage = "https://inspiralized.com/wp-content/uploads/2016/12/6A2A4801-scaled-500x375.jpg",
                            restaurantId = 8))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Vegan Pad Thai",
                                foodPrice = 10.49,
                                foodCategory = "Noodles",
                            foodImage = "https://cdn77-s3.lazycatkitchen.com/wp-content/uploads/2021/01/healthier-vegan-pad-thai-macro-1024x1536.jpg",
                            restaurantId = 8))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Crispy Portobello Mushroom Burger",
                            foodPrice = 9.99,
                            foodCategory = "Fast food",
                            foodImage = "https://food.fnr.sndimg.com/content/dam/images/food/fullset/2013/5/28/0/ZB0409H_panko-crusted-portobello-mushroom-burger-recipe_s4x3.jpg.rend.hgtvcom.616.462.suffix/1371616119154.jpeg",
                            restaurantId = 8))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Sweet Potato Fries Basket",
                            foodPrice = 12.49,
                            foodCategory = "Fast food",
                            foodImage = "https://stordfkenticomedia.blob.core.windows.net/df-us/rms/media/recipemediafiles/recipes/retail/desktopimages/sweet_potato_fries-600.jpg?ext=.jpg",
                            restaurantId = 8))

                            //res 9
                            capstoneViewModel.insertFood(Food(
                                foodName = "Mushroom Risotto with Truffle Oil",
                                foodPrice = 13.99,
                                foodCategory = "Rice",
                            foodImage = "https://cravingcalifornia.com/wp-content/uploads/2019/10/california_light_test-341-2-scaled.jpg",
                            restaurantId = 9))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Coconut Lime Tofu Rice Bowl",
                                foodPrice = 11.49,
                                foodCategory = "Rice",
                            foodImage = "https://tastythriftytimely.com/wp-content/uploads/2022/12/Coconut-Lime-Tofu-5.jpg",
                            restaurantId = 9))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Vegetable Miso Soup",
                                foodPrice = 7.99,
                                foodCategory = "Soup",
                            foodImage = "https://turniptheoven.com/wp-content/uploads/2015/10/Veggie-Loaded-Miso-Soup.jpg",
                            restaurantId = 9))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Roasted Red Pepper and Tomato Soup",
                            foodPrice = 8.99,
                            foodCategory = "Soup",
                            foodImage = "https://www.sainsburysmagazine.co.uk/uploads/media/1800x1800/08/4158-Roasted-red-pepper-and-cherry-tomato-soup---1120.jpg?v=1-0",
                            restaurantId = 9))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Avocado and Black Bean Fiesta Salad",
                            foodPrice = 9.49,
                            foodCategory = "Salad",
                            foodImage = "https://i0.wp.com/www.nutritionhappens.com/wp-content/uploads/2019/09/IMG_5325-2.jpg",
                            restaurantId = 9))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Roasted Beet and Quinoa Salad",
                                foodPrice = 10.99,
                                foodCategory = "Salad",
                            foodImage = "https://images.squarespace-cdn.com/content/v1/55c95b6ae4b064262a932403/1548619749113-OQO6B095N3WX6OWW53B2/beetquinoasalad-7.jpg",
                            restaurantId = 9))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Mixed Berry Vegan Cheesecake",
                            foodPrice = 5.99,
                            foodCategory = "Dessert",
                            foodImage = "https://talidavoinea.au/wp-content/uploads/2016/06/1L2A1355-copy.jpg",
                            restaurantId = 9))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Vegan Berry Coconut Tart",
                            foodPrice = 7.99,
                            foodCategory = "Dessert",
                            foodImage = "https://www.texanerin.com/content/uploads/2015/07/raspberry-coconut-tart-FI.jpg",
                            restaurantId = 9))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Stir-Fried Veggie Tofu Noodles",
                                foodPrice = 12.49,
                                foodCategory = "Noodles",
                            foodImage = "https://static.onecms.io/wp-content/uploads/sites/19/2015/05/04/stir-fried-tofu-broccoli-lo-mein-ay.jpg",
                            restaurantId = 9))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Sesame Garlic Zoodles",
                                foodPrice = 10.99,
                                foodCategory = "Noodles",
                            foodImage = "https://www.simplyquinoa.com/wp-content/uploads/2019/06/garlic-sesame-zucchini-noodles-5-500x500.jpg",
                            restaurantId = 9))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Crispy Cauliflower Tacos",
                                foodPrice = 9.99,
                                foodCategory = "Fast food",
                            foodImage = "https://www.halfbakedharvest.com/wp-content/uploads/2021/01/Crispy-Cauliflower-Tinga-Tacos-with-Honey-Lime-Avocado-Crema-1.jpg",
                            restaurantId = 9))

                            capstoneViewModel.insertFood(Food(
                                foodName = "Vegan BBQ Jackfruit Sandwich Combo",
                                foodPrice = 12.99,
                                    foodCategory = "Fast food",
                            foodImage = "https://piquantpost.com/cdn/shop/articles/BjIF94-tt1atKMshgIEoS_1000x.jpg?v=1690343995",
                            restaurantId = 9))
                        }
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
                            val listCount: List<Int> = listOf(55,56,57)
                            listCount.forEach {
                                    count ->
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
}
