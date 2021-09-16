package com.example.naari.models;

import java.util.ArrayList;

public class MountainData {
    public static String[][] data = new String[][] {
            {"What is a period?When does it start?",
                    "https://post.greatist.com/wp-content/uploads/sites/2/2019/10/period-collage-1200x628-facebook.jpg",
                    "A period refers, specifically, to the period where you're actually bleeding. Technically speaking, it's the part of your menstrual cycle when the uterus sheds its lining. It's normal for your cycle to be different from your friends' or even your sister's—a cycle can go from 21 days to more than 35, though Planned Parenthood notes 25 to 30 is the sweet spot for most people—and it's not even always the same from month to month.The average age you get your first period is between 12 and 15, but it can happen early or later than that. You can start menstruating as young as early as eight years old."},
            {"Is PMS(Premenstrual syndrome) real?",
                    "https://flo.health/uploads/media/sulu-1230x-inset/09/449-PMS%20symptoms.jpg?v=1-0&inline=1",
                    "Yes! Those emotional roller coaster rides, food cravings, bloating, breast tenderness, and body aches are the result of hormonal changes the week or two before your period arrives, so don't let anyone tell you differently. Feel your feelings and figure out the best way to manage them, and if they really begin to interrupt your life, talk to your doc. You may have a rare but severe form of PMS called PMDD"},
            {"Period Cramps Getting You Down? Try these remedies",
                    "https://livewellzone.com/wp-content/uploads/2020/10/does-a-heating-pad-help-with-menstrual-cramps.jpg",
                    "1. Use a heat patch-Using a heated patch or wrap on your abdomen can help relax the muscles of your uterus. It’s these muscles that cause period cramps\n"+"2. Take an OTC pain reliever.\n"+" 3.Exercise & Do yoga-One study suggests that,like aerobic exercise,yoga can also be helpful at reducing period cramps.\n"+" 4. Avoid caffeine and salty foods-A low-fat, vegetarian diet can help reduce period pain and premenstrual syndrome (PMS)symptoms.\n"+"5.Stay hydrated-Aim to drink eight 8-ounce glasses of water per day."},
            {"What Causes Irregular Periods?",
                    "https://naturalwomanhood.org/wp-content/uploads/AdobeStock_303429980-scaled.jpeg",
                    "Most of the time, irregular periods are part of the normal changes that can happen when you're a teen. As you get older, your cycle will probably settle into a recognizable pattern.Sometimes, irregular periods can be caused by some medicines, exercising too much, having a very low or high body weight, or not eating enough calories.Hormone imbalances can also cause irregular periods. For example, thyroid hormone levels that are too low or too high can cause problems with periods. Some girls have extra androgen, a hormone that can cause hair growth on the face, chin, chest, and abdomen. Extra androgen can also makes girls gain weight and have irregular periods."},
            {"Your periods may get worse during perimenopause",
                    "https://www.charlestonphysicians.com/wp-content/uploads/2019/10/graphic-for-what-perimenopause.jpg",
                    "Before they stop altogether when you reach menopause (the average age is 52), your periods will likely get longer and heavier, suggests a 2014 University of Michigan study. When researchers tracked more than 1,300 women between the ages of 42 and 52, they found that 91% reported their period occasionally lasted at least 10 days, 88% reported frequent spotting, and nearly 78% recorded at least three days of heavy flow."},
            {"Menstrual Cups",
                    "https://media1.popsugar-assets.com/files/thumbor/1nwxZl-vBzXbyYGVJrJd3OAuy9E/fit-in/2048xorig/filters:format_auto-!!-:strip_icc-!!-/2020/10/05/777/n/46902964/tmp_upALsw_8f86a2bcdda4c30e_GettyImages-1170566546.jpg",
                    "Menstrual cups are a form of internal period products that are used in place of tampons. Rather than absorb blood like a tampon, a menstrual cup collects and contains menstrual blood to prevent it from exiting the vagina. To dispose of the blood, the user pulls on a tab to remove the cup and pour out the blood, usually into a toilet. A menstrual cup is usually made of medical-grade silicone or rubber safe for inserting into the vagina.Most menstrual cups are reusable, meaning users can cleanse them between uses and keep them for many menstrual cycles before replacement is necessary. If you take proper care and cleanse them properly, they can last for years. "},


    };

    public static ArrayList<Mountain> getListData() {
        Mountain mountain;
        ArrayList<Mountain> list = new ArrayList<>();

        for (String[] mData : data) {
            mountain = new Mountain();
            mountain.setName(mData[0]);
            mountain.setPhoto(mData[1]);
            mountain.setDescription(mData[2]);

            list.add(mountain);
        }

        return list;
    }

}

