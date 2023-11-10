FROM python:3.10-slim
WORKDIR /app

# Requirements (caching)
COPY requirements.txt requirements.txt
RUN pip3 install -r requirements.txt

# Copy everything else
COPY . .

ENTRYPOINT ["python3"]
CMD ["-u", "main_nytimes.py"]
