/* 2115. Find All Possible Recipes from Given Supplies

You have information about n different recipes. You are given a string array recipes and a 2D string array ingredients. The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients from ingredients[i]. Ingredients to a recipe may need to be created from other recipes, i.e., ingredients[i] may contain a string that is in recipes.

You are also given a string array supplies containing all the ingredients that you initially have, and you have an infinite supply of all of them.

Return a list of all the recipes that you can create. You may return the answer in any order.

Note that two recipes may contain each other in their ingredients.
 */
class Solution 
{
    public List<String> findAllRecipes(String[] recipes,
                                       List<List<String>> ingredients,
                                       String[] supp) 
    {
        List<String> result = new ArrayList<String>();
        Map<String, List<String>> graph = new HashMap<String, List<String>>();
        Map<String, Boolean> visited = new HashMap<String, Boolean>();
        Map<String, Boolean> cooked = new HashMap<String, Boolean>();
        Set<String> supplies = new HashSet<String>();
        
        // recipes[i] -> list of its children
        for (int i = 0; i < ingredients.size(); ++i)         
            graph.put(recipes[i], ingredients.get(i));
        
        for (String s: supp)
            supplies.add(s);
        
        for (String s : recipes)
            if (canCook(s, graph, supplies, visited, cooked))
                result.add(s);
        
        return result;
    }

    private boolean canCook(String recipe, Map<String, List<String>> graph,
                            Set<String> supplies,
                            Map<String, Boolean> visited,
                            Map<String, Boolean> cooked)
    {
        List<String> childRecipes;

        if (visited.containsKey(recipe))
            return !visited.get(recipe);
        else if ((cooked.containsKey(recipe) && cooked.get(recipe)) ||     
                 supplies.contains(recipe))
            return true;

        childRecipes = graph.get(recipe);
        if (childRecipes == null && !supplies.contains(recipe))
            return false;
        visited.put(recipe, true);
        
        for (String s : childRecipes)
            if (!canCook(s, graph, supplies, visited, cooked))
            return false;

        visited.put(recipe, false);
        cooked.put(recipe, true);
        return true;
    }
}
