/*By Samantha MacAvoy:Updated: Jan 6, 2025, 45 Easy Breakfast Ideas for Even the Busiest Mornings
*[Online] Available at: https://www.goodhousekeeping.com/food-recipes/easy/g871/quick-breakfasts/   // morning meals
* [Accessed on 19 March 2025]

Children’s Food Trust: 2015, Mid-morning break recipes and tips
[online] Available at:https://laurelsprimary.co.uk/wp-content/uploads/2021/11/mid-morning-break.pdf   // Mid morning meals
* [Accessed on 19 March 2025]

By Kate Trombly O'BrienUpdated: Jan 2, 2025, 50 Quick and Easy Lunch Ideas for Any Busy Work Day
[online] Available at:https://www.thepioneerwoman.com/food-cooking/meals-menus/g37200073/quick-work-lunch-ideas/ //Afternoon meals
* [Accessed on 19 March 2025]

By Melanie Fincher Updated on January 17, 2024, 38 Quick Lunch Ideas You Can Make in 20 Minutes or Less
[online] Available at:https://www.allrecipes.com/gallery/quick-and-easy-lunch-recipes/   // Mid Afternoon
* [Accessed on 19 March 2025]

By taste.com.au,Top 100 easy dinner recipes
[online] Available at https://www.taste.com.au/quick-easy/galleries/top-100-easy-dinner-recipes/biccuul7?page=11   //Dinner meals
* [Accessed on 19 March 2025]


*/


package vcmsa.ci.mealapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private var editTextText: EditText? = null
    private var answer: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        // EditandText
        editTextText = findViewById(R.id.editTextText)
        answer = findViewById(R.id.answer)

        val Decidebtn = findViewById<Button>(R.id.Decidebtn)
        val Clearbtn = findViewById<Button>(R.id.Clearbtn)
        val exitbtn = findViewById<Button>(R.id.exitbtn)

        Clearbtn.setOnClickListener {
            answer?.text = ""
        }
        Decidebtn.setOnClickListener {
            Enter()
        }
        exitbtn.setOnClickListener {
            finishAffinity()
            exitProcess(1)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun isEmpty(): Boolean {
        return editTextText?.text.toString().trim().isEmpty() == true
    }

    @SuppressLint("SetTextI18n")
    private fun Enter() {
        if (isEmpty()){
            editTextText?.error = "invalid information"
            answer?.text = "invalid information"

        }

        val TimeOfTheDay = editTextText?.text.toString().trim()

        when (TimeOfTheDay){
            "Morning" -> answer?.text = "Omelette,Tomato and Feta Baked Eggs," +
                    "Double Apple Baked Oatmeal," +
                    "Sweet Potatoes with Yogurt," +
                    " Almond Butter and Pepita Granola and " +
                    "Skopo"
            "Mid Morning" -> answer?.text = "Fruits,bagels,Sandwiches" +
                    "Pasta, rice or noodles with meat" +
                    "or vegetable sauce"
            "Afternoon" -> answer?.text = "Snacks,Monte Cristo," +
                    "Instant Pot Sticky Pork Lettuce Wraps," +
                    "Ham and Cheese Pinwheels," +
                    ""
            "Mid Afternoon" -> answer?.text = "Sweet and Spicy Turkey Sandwich," +
                    "Pizza Lava Toast,Mexi-Chicken Avocado Cups,Chorizo Street Tacos" +
                    "Cream of Mashed Potato Soup"
            "Dinner" -> answer?.text = "Creamy French onion chicken pasta," +
                    "fried rice,butter chicken,braised steak and onions," +
                    "Curried sausages recipe,lasagne and " +
                    "Amasi"
            else -> {
                answer?.text = "Invalid time of the day, enter what is provided in the example above."
            }
        }

    }
}