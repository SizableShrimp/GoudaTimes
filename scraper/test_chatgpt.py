import os
import openai

openai.api_key = os.getenv("OPENAI_API_KEY")

response = openai.ChatCompletion.create(
  model="gpt-3.5-turbo",
  messages=[
    {
      "role": "system",
      "content": "I will give the title and some other information about a news article. Write the article. Being consistent with the title, which should be about cheese, is the most important part."
    },
    {
      "role": "user",
      "content": "Title: U.S. Officials Outline Steps to Accommodate Cheesy Delights in Israel's Cuisine"
    }
  ],
  temperature=1,
  max_tokens=256,
  top_p=1,
  frequency_penalty=0,
  presence_penalty=0
)

print(response["choices"][0]["message"]["content"])
